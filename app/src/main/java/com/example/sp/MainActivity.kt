package com.example.sp

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    var titulo : TextView?=null
    var cont : TextView?=null
    var campotitulo : EditText?=null
    var campoCont : EditText?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        inicio()
        cargar()
        eliminar ()
        val sharedPreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)
        val isFirstRun = sharedPreferences.getBoolean("isFirstRun", true)
        if (isFirstRun) {
    
            val intent = Intent(this, MensajeInicio::class.java)
            startActivity(intent)

            val editor = sharedPreferences.edit()
            editor.putBoolean("isFirstRun", false)
            editor.apply()

        }
        val botonAyuda :Button=findViewById(R.id.botonAyuda)
        botonAyuda.setOnClickListener {
            val intent = Intent(this, MensajeInicio::class.java)
            startActivity(intent)
        }
    }

    private fun inicio(){
        var btnGuardar:Button=findViewById(R.id.buttonG)
        btnGuardar.setOnClickListener{guardar()}
        var btnCargar : Button=findViewById(R.id.buttonC)
        btnCargar.setOnClickListener{cargar()}
        var btnEliminar:Button=findViewById(R.id.buttonE)
        btnEliminar.setOnClickListener{eliminar()}

        titulo=findViewById(R.id.titulo)
        cont=findViewById(R.id.content)
        campotitulo=findViewById(R.id.campoTitulo)
        campoCont=findViewById(R.id.Campocontent)

    }


    private fun guardar() {
        var preferences: SharedPreferences =getSharedPreferences("credenciales", Context.MODE_PRIVATE)
        var title = campotitulo?.text.toString()
        var contenido = campoCont?.text.toString()

        var editor: SharedPreferences.Editor = preferences.edit()
        editor.putString("title", title)
        editor.putString("contenido", contenido)

        titulo?.text=title
        cont?.text=contenido

        editor.commit()

        Toast.makeText(this, "Datos Registrados", Toast.LENGTH_LONG).show()

    }
    private fun cargar () {
        var preferences:SharedPreferences=getSharedPreferences("credenciales",Context.MODE_PRIVATE)
        var titu: String? = preferences.getString("title", "No existe la informacion")
        var cnt: String? = preferences.getString("contenido", "No existe la informacion")

        titulo?.text=titu
        cont?.text=cnt
        Toast.makeText(this, "Datos cargados", Toast.LENGTH_LONG).show()
    }
    private fun eliminar(){
        var preferences:SharedPreferences=getSharedPreferences("credenciales", Context.MODE_PRIVATE)
        var elim: SharedPreferences.Editor=preferences.edit()
        elim.clear()
        elim.commit()
    }


}