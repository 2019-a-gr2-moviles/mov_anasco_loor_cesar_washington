package com.example.proyecto_pokemon

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_registro_entrenador.*
import android.app.AlertDialog
import android.content.DialogInterface
import android.support.design.widget.TextInputEditText
import com.google.gson.Gson
import com.example.proyecto_pokemo.Post
import java.io.*

class RegistroEntrenador : AppCompatActivity() {

    private var jsonInicial:String? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro_entrenador)

        botonRegistrarEntrenador.setOnClickListener {

            try {

                val et_idInput = findViewById<TextInputEditText>(R.id.idInput)
                val et_nombreInput = findViewById<TextInputEditText>(R.id.nombreInput)
                val et_nacionalidadInput = findViewById<TextInputEditText>(R.id.paisOrigenInput)
                val id = et_idInput.text.toString().toInt()
                val nombre = et_nombreInput.text.toString()
                val nacionalidad = et_nacionalidadInput.text.toString()

                agregarRegistroAJson(id,nombre,nacionalidad)
                mostrarMensajeExito()
            } catch (e: IOException) {
                mostrarMensajeError(e.toString())
            }

        }



    }


    private fun agregarRegistroAJson(Id: Int, Nombre: String, Nacionalidad:String) {
        leerJson()
        var post = Post(Id, Nombre, Nacionalidad)
        var gson = Gson()
        var jsonString:String = gson.toJson(post)
        var jsonString2:String = jsonInicial.toString()
        var jsonFinal = jsonString2 +  ',' +jsonString.toString()
        //textView.setText(jsonString)
        val file=File("/data/data/com.example.proyecto_pokemon/files/Entrenadores.json")
        file.writeText(jsonFinal)
    }


    private fun leerJson() {
        var gson = Gson()
        val bufferedReader: BufferedReader = File("/data/data/com.example.proyecto_pokemon/files/Entrenadores.json").bufferedReader()
        val inputString = bufferedReader.use { it.readText() }
        jsonInicial = inputString
    }

    fun mostrarMensajeExito() {
        val dialogBuilder = AlertDialog.Builder(this)
        dialogBuilder.setMessage("Registrado con exito!")
            .setCancelable(false)
            .setPositiveButton("OK", DialogInterface.OnClickListener() { dialog, id ->
                dialog.cancel()
            })

        val alert = dialogBuilder.create()
        alert.show()
    }

    fun mostrarMensajeError(e: String) {

        val dialogBuilder = AlertDialog.Builder(this)
        dialogBuilder.setMessage(e)
            .setCancelable(false)
            .setPositiveButton("OK", DialogInterface.OnClickListener() { dialog, id ->
                dialog.cancel()
            })

        val alert = dialogBuilder.create()
        alert.show()
    }



}
