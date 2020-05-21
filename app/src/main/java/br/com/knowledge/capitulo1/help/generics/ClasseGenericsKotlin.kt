package br.com.knowledge.capitulo1.help.generics

import br.com.concrete.canarinho.formatador.Formatador
import br.com.knowledge.widge.withDrawMaskMoney
import java.lang.IllegalArgumentException
import java.lang.NumberFormatException
import java.math.BigDecimal
import java.math.RoundingMode
import java.text.DecimalFormat
import java.text.NumberFormat
import java.util.*
import java.util.regex.Pattern


/**
 * para criar uma instancia de uma classe
 * precisamos prover o tipo de argumentos
 * */
class Box<T>(t: T) {
    var value = t
}

val box: Box<Int> = Box(2)
val box2 = Box("Teste")

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

// métodos usando genéricos
/*fun <T> singleList(item: T) : List<T>{
    val l: List<T> = arrayListOf(item)
    return  l
}

fun <T> T.basicToString(): String{
    return this.toString()
}*/

fun main() {

    //println("${box.value}")
    //println("${box2.value}")

    //genericos com funcao
    //genericsWithFun()

   /* val inteiro = singleList(3)
    val stringer = singleList("sim")
    val doublefloat = singleList(33f)

    println("$inteiro --- $stringer --- $doublefloat")*/

    //val int = 30
    //val dob = 30f
    //println(maskMoney(int))
    //println(maskMoney(dob))

    val str = "R$ 44.000,00"

    val s = withDrawMaskMoney(str)

    println(s)


}
