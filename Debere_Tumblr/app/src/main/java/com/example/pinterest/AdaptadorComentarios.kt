
package com.example.pinterest

import android.content.Intent
import android.content.Intent.FLAG_ACTIVITY_NEW_TASK
import android.graphics.drawable.Drawable
import android.media.Image
import android.support.v4.content.res.TypedArrayUtils
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*

class AdaptadorComentarios(
    private val listaImg:List<Imagenes>,
    private val contexto:Informacion,
    private val recyclerView:RecyclerView
):
    RecyclerView.Adapter<AdaptadorComentarios.MyViewHolder>(){
    var indice:Int=0


    inner class MyViewHolder(view:View):RecyclerView.ViewHolder(view){
        var textViewNombreUsuario:TextView
        var textViewDescripcio:TextView
        var btnLike: Button



        init{
            textViewNombreUsuario = view.findViewById(R.id.textViewNombreUsuario) as TextView
            textViewDescripcio = view.findViewById(R.id.textViewDescripcion) as TextView
            btnLike = view.findViewById(R.id.btnLikeView) as Button

            val layout = view.findViewById(R.id.layoutcomen) as LinearLayout

            layout.setOnClickListener {
                Log.i("imagen","imagenPresionanada")

            }
            btnLike.setOnClickListener {
                btnLike.text = "YA NO ME GUSTA"
            }
        }
    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int):
            AdaptadorComentarios.MyViewHolder {
        val itemView = LayoutInflater
            .from(p0.context)
            .inflate(
                R.layout.layout_comen,
                p0,
                false
            )
        return MyViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return listaImg.size
    }

    override fun onBindViewHolder(myViewHolder: AdaptadorComentarios.MyViewHolder,
                                  position: Int){
        val foto = listaImg[position]
        myViewHolder.textViewNombreUsuario.text = listaImg[position].txtInfo
        myViewHolder.textViewDescripcio.text = listaImg[position].descripcion
    }

}