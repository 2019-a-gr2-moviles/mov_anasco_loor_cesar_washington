package com.example.myapplication

import android.app.Person
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView

class AdaptadorPersona(
    private val listaPersonas: List<Persona>,
    private val contexto: ReciclerViewActivity,
    private val recyclerView: RecyclerView
) :
    RecyclerView.Adapter<AdaptadorPersona.MyViewHolder>() {

    inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        var nombreTextView: TextView
        var cedulaTextView: TextView
        var accionBoton: Button

        init {
            nombreTextView = view.findViewById(R.id.txt_nombre) as TextView
            cedulaTextView = view.findViewById(R.id.txt_cedula) as TextView
            accionBoton = view.findViewById(R.id.btn_accion) as Button

            val layout = view.findViewById(R.id.linear_layout) as LinearLayout

            layout
                .setOnClickListener {

                    Log.i("recycler-view", "Layout presionado")

                }

            accionBoton.setOnClickListener {
                nombreTextView.text = "ME CAMBIAROOOOOOON!!! "
                contexto.cambiarNombreTextView("WOW!")

                val nuevasPersonas = arrayListOf<Persona>()
                nuevasPersonas.add(Persona("Felipe", "1717370975"))
                nuevasPersonas.add(Persona("Felipe2", "1717370976"))
                nuevasPersonas.add(Persona("Felipe3", "1717370977"))

                contexto.iniciarRecylerView(nuevasPersonas, contexto, recyclerView)
            }
        }

    }

    // Devuelve el # de items de la lista
    override fun getItemCount(): Int {
        return listaPersonas.size
    }

    override fun onBindViewHolder(
        myViewHolder: AdaptadorPersona.MyViewHolder,
        position: Int
    ) {

        val persona = listaPersonas[position]

        myViewHolder.nombreTextView.text = persona.nombre
        myViewHolder.cedulaTextView.text = persona.cedula

    }

    // Esta funcion define el template que vamos a utilizar
    // El template esta en la carpeta de res/layout
    override fun onCreateViewHolder(
        p0: ViewGroup,
        p1: Int
    ):
            AdaptadorPersona.MyViewHolder {
        val itemView = LayoutInflater
            .from(p0.context)
            .inflate(
                R.layout.layout,
                p0,
                false
            )

        return MyViewHolder(itemView)
    }


}