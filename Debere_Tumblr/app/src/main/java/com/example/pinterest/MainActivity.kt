package com.example.pinterest

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val lista = arrayListOf<Imagenes>()
        val recycler_view=rv_example2
        val activity = this


        lista.add(Imagenes("WASHIOS",R.drawable.img_uno,"Sorry the person you ar trying to reach has moved on. #Hey#there #lol #quote #tumblr #haha #lol #oh #yrah #thats #what #we #call #it #uo #thos #moment"))
        lista.add(Imagenes("CHILLY",R.drawable.img_dos,"Pense que si nos veríamos al regresar. No sabia como mas decirte todo lo que he sentido desde que llegue. No respondías y pensé que la idea de vernos ya no era una opción. Ya se que pienso. Si quieres hablar dímelo. Si ya no quieres verme tambien esta bien. #QUOTE # COMEBACK #ALV "))
        lista.add(Imagenes("ORUNA",R.drawable.img_tres,"El desempeño del estudiante fue satisfactorio. Cumplio con las tareas asignadas con entusiasmo y responsabilidad. Existieron muchos vaciós de conocimento del manejo del computador por parte del estudiante que se instrulleron satisfactoriamente en las capacitaciones. #YES # YES #JEJE #ALV" ))
        lista.add(Imagenes("TEKOO",R.drawable.img_cuatro,"Pense que si nos veríamos al regresar. No sabia como mas decirte todo lo que he sentido desde que llegue. No respondías y pensé que la idea de vernos ya no era una opción. Ya se que pienso. Si quieres hablar dímelo. Si ya no quieres verme tambien esta bien. ."))

        iniciarRV(lista,this,recycler_view)


    }

    fun iniciarRV(
        lista:List<Imagenes>,
        actividad:MainActivity,
        recyclerView: RecyclerView
    ){
        val adaptador = AdaptadorImagenes(
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
