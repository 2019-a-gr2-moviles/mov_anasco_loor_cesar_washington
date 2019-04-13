import java.util.*
import kotlin.collections.ArrayList

fun  main(args: Array<String>) {

    // VARIABLES

    // Mutables

    var nombre = "Adrian"
    nombre = "Vicente"

    //Inmutables -> Es mejor.

    val nombre2 = "Washo"
    //nombre2 = "Washio"


    // TIPOS DE DATOS

    val apellido: String = "Washo"
    val edad: Int = 29
    val sueldo: Double = 1.21
    val casado: Boolean = true
    val profesor: Boolean = true
    val hijos = null

    //DUCK TYPING
    //Si parece un pato, si camina como pato, si suena como pato y si vuela como pato
    //PATO

    //CONDICIONALES

    if (apellido == "Washo" || nombre == "Washiof") {
        println("Verdadero")
    } else {
        println("Falso")
    }

    val tieneNombreYApellido = if (apellido != null && nombre != null) "ok" else "no"
    println(tieneNombreYApellido)
    estaJalado(1.0)
    estaJalado(8.0)
    estaJalado(0.0)
    estaJalado(7.0)
    estaJalado(10.0)

    holaMundo("Washio")
    holaMundoAvanzado(2)
    var total = sumarDosNumeros(1,3)
    println(total)

    val arregloCumpleanos: Array<Int> = arrayOf(1,2,3,4)
    val arregloTodo: Array<Any> = arrayOf(1, "asd", 10.2, true)

    arregloCumpleanos[0] = 5
    arregloCumpleanos.set(0,5)

   // arregloCumpleanos = arrayOf(5,2,3,4)

    //val notas: ArrayList<Int> = arrayListOf<Int>(1,2,3,4,5)   Duck Typing
    val notas = arrayListOf(1,2,3,4,5)

    val fecha = Date()
    fecha.time = 11231231
    fecha.year = 2000

   //OPERADORES

    val notasDos = notas.map {
        nota -> nota + 1
    }

    notasDos.forEach{
        println("Notas 2: $it")
    }

    //forEach --> itera el arreglo

    notas.forEachIndexed{indice, nota: Int ->
        println("Indice: $indice")
        println("Nota: $nota")

        return Unit
    }

    val respuestaFilter = notas.filter {//flitra

        //it > 2

        it in 3..4


    }
        .map{  // muta o cambia el arreglo
            it *2
        }

    respuestaFilter.forEach{ println(it)} //imprimir, iterar

    val novias = arrayListOf(1,2,2,3,4,5)

    val respsuestaNovia = novias.any {
            it == 3
        }

    println(respsuestaNovia)

    val notasTres = notas.map { nota ->
        val modulo = nota % 2
        val esPar = 0
        when (modulo) {
            esPar -> {
                nota + 1
            }
            else -> {
                nota + 2
            }
        }
    }

    notasTres.forEach {
        println("Notas 3: $it")
    }


    // Por que arrayOf no deja cambiar valores? Se puede modificar la clase pero no la variable de la clase

    // Variable Inmutable

    val tazos = arrayListOf(1,2,3,4,5,6,7)

    val respuestaTazos = tazos.all {
        it >1
    }
    println(respuestaTazos)



    val totalTazos = tazos.reduce { valorAcumulado, tazo ->
        valorAcumulado + tazo
    }

    println(totalTazos)

    }

    //en kotlin no existe switch

    fun estaJalado(nota: Double){

        when(nota) {
            7.0 -> {
                println("Pasastec con las justas")
            }
            10.0 -> {
                println("Genial :D Felicitaciones")
            }
            0.0 -> {
                println("Dios mio que vago!")
            }
            else -> {
                println("Tu notas es: $nota")
            }
        }

    }


fun holaMundo(mensaje: String):Unit {   //Unit--->El void de kotlin

    println("Mensaje: ${mensaje}.")

}

fun holaMundoAvanzado(mensaje: Any):Unit {   //Unit--->El void de kotlin

    println("Mensaje: ${mensaje}.")

}


fun sumarDosNumeros(numUno: Int, numDos: Int):Int {
  return numUno + numDos
}



