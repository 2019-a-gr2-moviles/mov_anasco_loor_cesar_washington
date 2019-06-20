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

class AdaptadorImagenes(
    private val listaImg:List<Imagenes>,
    private val contexto:MainActivity,
    private val recyclerView:RecyclerView
):
        RecyclerView.Adapter<AdaptadorImagenes.MyViewHolder>(){
    var indice:Int=0


    inner class MyViewHolder(view:View):RecyclerView.ViewHolder(view){
        var imageView1:ImageView
        var textViewNombreUsuario:TextView
        var textViewDescripcio:TextView
        var btnLike: Button
        var btnComent: Button



        init{
            imageView1 = view.findViewById(R.id.img1) as ImageView
            textViewNombreUsuario = view.findViewById(R.id.textViewNombreUsuario) as TextView
            textViewDescripcio = view.findViewById(R.id.textViewDescripcion) as TextView
            btnLike = view.findViewById(R.id.btnLikeView) as Button
            btnComent = view.findViewById(R.id.btnComentView) as Button

            val layout = view.findViewById(R.id.layoutg) as LinearLayout

            layout.setOnClickListener {
                Log.i("imagen","imagenPresionanada")

            }
            btnLike.setOnClickListener {
                btnLike.text = "YA NO ME GUSTA"
            }
        }
    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int):
            AdaptadorImagenes.MyViewHolder {
        val itemView = LayoutInflater
            .from(p0.context)
            .inflate(
                R.layout.layout,
                p0,
                false
            )
        return MyViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return listaImg.size
    }

    override fun onBindViewHolder(myViewHolder: AdaptadorImagenes.MyViewHolder,
                                  position: Int){
        val foto = listaImg[position]
        myViewHolder.imageView1.setImageResource(foto.imageId)

        myViewHolder.btnComent.setOnClickListener{
            indice = myViewHolder.adapterPosition
            Log.i("posicion",indice.toString())
            val intent = Intent(contexto.applicationContext,Informacion::class.java)
            intent.addFlags(FLAG_ACTIVITY_NEW_TASK)
            val listaExtra = Imagenes(foto.txtInfo,foto.imageId,foto.descripcion)
            intent.putExtra("imagen",listaExtra)
            contexto.applicationContext.startActivity(intent)
        }
        myViewHolder.textViewNombreUsuario.text = listaImg[position].txtInfo
        myViewHolder.textViewDescripcio.text = listaImg[position].descripcion
    }

}