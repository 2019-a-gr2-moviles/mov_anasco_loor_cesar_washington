package com.example.proyecto_pokemon

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.google.gson.Gson
import java.io.BufferedReader
import java.io.File

class AccionEntrenador : AppCompatActivity() {


    private var jsonInicial:String? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_accion_entrenador)

        llenarInputText(Pantalla_Entrenador().element.toString())

    }


    private fun leerJson() {
        var gson = Gson()
        val bufferedReader: BufferedReader = File("/data/data/com.example.proyecto_pokemon/files/Entrenadores.json").bufferedReader()
        val inputString = bufferedReader.use { it.readText() }
        jsonInicial = inputString
    }


    private fun llenarInputText(nombre: String) {

    }

}




