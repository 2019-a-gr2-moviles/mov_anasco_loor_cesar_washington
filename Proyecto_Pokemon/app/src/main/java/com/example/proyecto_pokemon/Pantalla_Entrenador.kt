package com.example.proyecto_pokemon

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_pantalla__entrenador.*
import org.json.JSONArray
import org.json.JSONObject
import java.io.IOException
import java.io.InputStream

class Pantalla_Entrenador : AppCompatActivity() {

    var arr = arrayListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pantalla__entrenador)
        read_json()
    }

    fun read_json() {
        var json: String? = null

        try {
            val inputStream: InputStream = assets.open("Entrenadores.json")
            json = inputStream.bufferedReader().use { it.readText() }

            var jsonarr = JSONArray(json)

            for (i in 0..jsonarr.length()-1) {
                var jsonobj = jsonarr.getJSONObject(i)
                arr.add(jsonobj.getString("nombre"))
            }

            var adpt = ArrayAdapter(this, android.R.layout.simple_list_item_1,arr)
            ListViewEntrenador.adapter = adpt
        }
        catch (e: IOException) {

        }
    }

}
