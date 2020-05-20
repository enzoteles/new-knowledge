package br.com.knowledge.capitulo1.help.generics

/**
 * para criar uma instancia de uma classe
 * precisamos prover o tipo de argumentos
 * */
class Box<T>(t: T) {
    var value = t
}

val box: Box<Int> = Box(2)
val box2 = Box("Teste")

fun main() {

    //println("${box.value}")
    //println("${box2.value}")

    //genericos com funcao
    genericsWithFun()
    


}

private fun genericsWithFun() {
    //função anonimas com generics
    val compareAandB = object : Compare<Int> {
        override fun compareTo(first: Int, second: Int): Int {
            if (first > second) {
                println("$first")
                return first
            } else {
                println("$second")
                return second
            }

        }
    }

    val valores = compareAandB
    valores.compareTo(5, 6)
}

interface Compare<in T> {
    fun compareTo(first: T, second: T): Int
}
