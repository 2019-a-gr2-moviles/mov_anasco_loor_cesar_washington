package com.example.proyecto_pokemon

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_pantalla__entrenador.*
import org.json.JSONArray
import java.io.File
import java.io.IOException
import java.io.InputStream

class Pantalla_Entrenador : AppCompatActivity() {

    var arrListaEntrenador = arrayListOf<String>()
    var arrListaNacionalidad = arrayListOf<String>()
    var element:String? = null

    private var stringBuilder:StringBuilder?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pantalla__entrenador)
        listarJsonArray()
        
        botonNuevoEntrenador.setOnClickListener {
            val intent = Intent(this, RegistroEntrenador::class.java)
            startActivity(intent)
        }

        listViewEntrenador.setOnItemClickListener { parent, view, position, id ->
            element = listViewEntrenador.selectedItem.toString()
                //adapter.getItemAtPosition(position) // The item that was clicked
            val intent = Intent(this, AccionEntrenador::class.java)
            startActivity(intent)
        }

    }



    fun listarJsonArray() {
        var json: String? = null

        try {
            val inputStream: InputStream = File("/data/data/com.example.proyecto_pokemon/files/Entrenadores.json").inputStream()
            json = inputStream.bufferedReader().use { it.readText() }
            val jsonCompleto: String = "[" + json.toString() + "]"
            var jsonarr = JSONArray(jsonCompleto)

            for (i in 0..jsonarr.length()-1) {
                var jsonobj = jsonarr.getJSONObject(i)
                arrListaEntrenador.add(jsonobj.getString("nombre"))
                arrListaNacionalidad.add(jsonobj.getString("nacionalidad"))
            }
            var adpt = ArrayAdapter(this, android.R.layout.simple_list_item_2,arrListaEntrenador)
            //adpt = ArrayAdapter(this, android.R.layout.simple_list_item_2,arrListaNacionalidad)
            listViewEntrenador.adapter = adpt
        }
        catch (e: IOException) {
            println(e.toString())
        }
    }






}
