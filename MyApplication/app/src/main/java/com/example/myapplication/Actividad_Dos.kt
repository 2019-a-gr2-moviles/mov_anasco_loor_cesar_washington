package com.example.myapplication

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class Actividad_Dos : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_actividad__dos)
    }

    fun irAActividadTres() {
        val intent = Intent(this, Actividad_Dos::class.java)
        startActivity(intent)
    }


}
