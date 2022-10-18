package com.example.restauranteparceros

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class RegistroActivity : AppCompatActivity() {

    private lateinit var btnRegistrarse : Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro)

        btnRegistrarse = findViewById(R.id.registro_button_registrarse)

        btnRegistrarse.setOnClickListener {

            this.finish();
        }
    }
}