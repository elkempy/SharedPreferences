package com.example.sp

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MensajeInicio : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mensaje_inicio)
        val btncerrar: Button=findViewById(R.id.btncerrar)
        btncerrar.setOnClickListener {salir()}
        }

    private fun salir(){
        finish()
    }

    }

