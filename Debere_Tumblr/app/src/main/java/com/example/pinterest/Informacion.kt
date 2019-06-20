package com.example.pinterest

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_informacion.*

class Informacion : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_informacion)

        val image:Imagenes?=this.intent.getParcelableExtra("imagen")

        txtInfo.text=image?.txtInfo
        imagenInfo.setImageResource(image!!.imageId)
        txtDescripcion.text = image?.descripcion


        val lista = arrayListOf<Imagenes>()
        val recycler_view=rv_example2
        val activity = this


        lista.add(Imagenes("WASHIOS",R.drawable.img_uno,"Sorry sorry sorryyy..."))
        lista.add(Imagenes("CHILLY",R.drawable.img_dos,"Pense que si estaba chevere #alv"))
        lista.add(Imagenes("ORUNA",R.drawable.img_tres,"El desempeño fue bueno.  #YES " ))
        lista.add(Imagenes("TEKOO",R.drawable.img_cuatro,"Pense que si estaba chevere #alv."))

        iniciarRV(lista,this,recycler_view)

    }

    fun iniciarRV(
        lista:List<Imagenes>,
        actividad:Informacion,
        recyclerView: RecyclerView
    ){
        val adaptador = AdaptadorComentarios(
            lista,
            actividad,
            recyclerView
        )
        recyclerView.adapter = adaptador
        recyclerView.itemAnimator = DefaultItemAnimator()
        recyclerView.layoutManager = LinearLayoutManager(actividad)

        adaptador.notifyDataSetChanged()
    }
}
