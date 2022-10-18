package com.example.restauranteparceros

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {

    private lateinit var btnRegistro : Button
    private lateinit var etCorreo : EditText
    private lateinit var etPass : EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnRegistro = findViewById(R.id.login_button_registrar)
        etCorreo = findViewById(R.id.login_et_correo)
        etPass = findViewById(R.id.login_et_pass)

        btnRegistro.setOnClickListener {

            val i = Intent(this, RegistroActivity::class.java)
            startActivity(i)
        }

    }
}