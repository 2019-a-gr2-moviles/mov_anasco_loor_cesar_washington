package com.example.myapplication

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_recicler_view.*

class ReciclerViewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recicler_view)

        val lista = arrayListOf<Persona>()
        val recycler_view = rv_personas
        val actividad = this

        lista.add(Persona("Adrian","171819134"))
        lista.add(Persona("Vicente","0192839495"))
        lista.add(Persona("Adrian","2003938182"))

        val adaptadorPersona = AdaptadorPersona(lista,
            actividad,
            recycler_view)

        rv_personas.adapter = adaptadorPersona
        rv_personas.itemAnimator = DefaultItemAnimator()
        rv_personas.layoutManager = LinearLayoutManager(this)

        adaptadorPersona.notifyDataSetChanged()


    }

}
