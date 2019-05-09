package com.example.proyecto_pokemo

import com.google.gson.annotations.SerializedName

data class Entrenador(
    @SerializedName("id") val id: Int,
    @SerializedName("nombre") val nombre: String,
    @SerializedName("nacionalidad") val nacionalidad: String
)

class Post {
    var id: Number? = null
    var nombre: String? = null
    var nacionalidad: String? = null
    //var postTag: List<String>? = null

    constructor() : super() {}

    constructor(Id: Number, Nombre: String, Nacionalidad: String) : super() {
        this.id = Id
        this.nombre = Nombre
        this.nacionalidad = Nacionalidad
    }

}