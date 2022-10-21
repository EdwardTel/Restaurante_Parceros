package com.example.restauranteparceros

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.android.material.textfield.TextInputLayout
import com.google.firebase.ktx.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import java.util.regex.Pattern

class MainActivity : AppCompatActivity() {

    private lateinit var btnLogin : Button
    private lateinit var btnRegistro : Button
    private lateinit var etEmail : EditText
    private lateinit var etPass : EditText


    private lateinit var firebaseAuth : FirebaseAuth
    private lateinit var authStateListener : FirebaseAuth.AuthStateListener

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnLogin = findViewById(R.id.login_button_login)
        btnRegistro = findViewById(R.id.login_button_registrar)
        etEmail = findViewById(R.id.login_et_email)
        etPass = findViewById(R.id.login_et_pass)


        firebaseAuth = Firebase.auth



        btnLogin.setOnClickListener {
            if(etEmail.text.isEmpty() || etPass.text.isEmpty()){
                Toast.makeText(baseContext,"Inválido, hay campos vacíos", Toast.LENGTH_SHORT).show()
            }

            else{
                var userEmail = etEmail.text.toString()
                var userPass = etPass.text.toString()
                singIn(userEmail,userPass)
            }
        }

        btnRegistro.setOnClickListener {
            val i = Intent(this, RegistroActivity::class.java)
            startActivity(i)
        }
    }

    private fun singIn(email: String,  password: String ){

        firebaseAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(this){
            if(it.isSuccessful){
                val user = firebaseAuth.currentUser
                Toast.makeText(baseContext,user?.uid.toString(), Toast.LENGTH_SHORT).show()
                Toast.makeText(baseContext,"Logueado Correctamente!", Toast.LENGTH_SHORT).show()

                //Aqui se inicia el siguiente activity
            }

            else{
                Toast.makeText(baseContext,"Correo o contraseña no válidos", Toast.LENGTH_SHORT).show()
            }
        }
    }
}