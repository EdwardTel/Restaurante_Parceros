package com.example.restauranteparceros

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class CambiarPassActivity : AppCompatActivity() {

    private lateinit var firebaseAuth: FirebaseAuth
    private lateinit var btnRestablecerContraseña : Button
    private lateinit var etCorreo : EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cambiar_pass)

        btnRestablecerContraseña = findViewById(R.id.cambiar_pass_button_enviar_correo)
        etCorreo = findViewById(R.id.cambiar_pass_et_correo)

        firebaseAuth = Firebase.auth

        btnRestablecerContraseña.setOnClickListener {

            if(etCorreo.text.isNullOrEmpty()){
                Toast.makeText(baseContext,"No se envió ningún correo",Toast.LENGTH_SHORT).show()
                this.finish()
            }
            else{
                sendPasswordReset(etCorreo.text.toString())
                this.finish()
                Toast.makeText(baseContext,"Enviado correctamente",Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun sendPasswordReset (email: String){
        firebaseAuth.sendPasswordResetEmail(email).addOnCompleteListener(){
            if(it.isSuccessful){
                Toast.makeText(baseContext,"Enviado correctamente",Toast.LENGTH_SHORT).show()
            }
            else{
                Toast.makeText(baseContext, "No se pudo completar la operación", Toast.LENGTH_SHORT).show()
            }
        }
    }
}