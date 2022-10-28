package com.example.restauranteparceros

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputLayout
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class RegistroActivity : AppCompatActivity() {

    private lateinit var etNombre : EditText
    private lateinit var etApellido : EditText
    private lateinit var etTelefono : EditText
    private lateinit var etEmail : EditText
    private lateinit var etPass : EditText
    private lateinit var tilPass : TextInputLayout

    private lateinit var btnRegistrarse : Button
    private lateinit var btnRegresar : Button

    private lateinit var firebaseAuth: FirebaseAuth


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro)

        etNombre = findViewById(R.id.registro_et_nombre)
        etApellido = findViewById(R.id.registro_et_apellido)
        etTelefono = findViewById(R.id.registro_et_telefono)
        etEmail = findViewById(R.id.registro_et_email)
        etPass = findViewById(R.id.registro_et_password)
        tilPass = findViewById(R.id.registro_til_pass)

        btnRegistrarse = findViewById(R.id.registro_button_registrarse)
        btnRegresar = findViewById(R.id.registro_btn_regresar)

        firebaseAuth = Firebase.auth

        etPass.addTextChangedListener(object: TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                var pass = p0.toString()
                if(pass.length >= 8){
                    var passPattern = """^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#${'$'}%!\-_?&])(?=\S+${'$'}).{8,}""".toRegex()
                    var coincide = passPattern.matches(pass)
                    if(coincide) {
                        tilPass.helperText = "Contraseña fuerte"
                        tilPass.error = ""
                    }else{
                        tilPass.helperText = "Contraseña débil"
                        tilPass.error = "Incluye 1 mayus,1 minus, 1#"
                    }

                }else{
                    tilPass.helperText = "Mínimo 8 caracteres"
                    tilPass.error = ""
                }
            }

            override fun afterTextChanged(p0: Editable?) {
            }
        })

        btnRegistrarse.setOnClickListener {

            if(etNombre.text.isEmpty() ||
                etApellido.text.isEmpty() ||
                etTelefono.text.isEmpty() ||
                etEmail.text.isEmpty() ||
                etPass.text.isEmpty()){

                Toast.makeText(baseContext,"Inválido, hay campos vacíos", Toast.LENGTH_SHORT).show()
            }
            else{
                var userNombre = etNombre.text.toString()
                var userApellido = etNombre.text.toString()
                var userTelefono = etTelefono.text.toString()
                var userEmail = etEmail.text.toString()
                var userPass = etPass.text.toString()

                createAccount(userNombre, userApellido, userTelefono, userEmail, userPass)
            }
        }

        btnRegresar.setOnClickListener {
            this.finish()
        }
    }

    private fun createAccount(nombre: String, apellido: String, telefono: String, email: String, pass: String){

        firebaseAuth.createUserWithEmailAndPassword(email,pass).addOnCompleteListener(this){
            if(it.isSuccessful){
                Toast.makeText(baseContext,"Creado Correctamente!", Toast.LENGTH_LONG).show()
                this.finish()
            }
            else{
                Snackbar.make(btnRegistrarse,"Error: ${it.exception}", Snackbar.LENGTH_LONG ).setTextMaxLines(5).show()
            }
        }
    }
}