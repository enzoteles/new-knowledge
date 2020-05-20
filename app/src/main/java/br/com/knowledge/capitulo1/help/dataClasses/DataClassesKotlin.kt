package br.com.knowledge.capitulo1.help.dataClasses

data class Casa(var name: String, var ige: Int)

fun main(){

    println("$time")

}

fun copy(){
    val casa = Casa("branca", 2)
    //função copy é para apenas mudar um ou mais atributos mais manter os outros que não foi mudado.
    val casaNova = casa.copy(ige = 5)

    println("$casa")
    println("$casaNova")
}

//usando o destructurin declarations
fun destructur(){

    val casa = Casa("Preta", 33)
    val (name, age) = casa
    println("$name --- $age")

}

val time: Long
    get() = 5.toLong()