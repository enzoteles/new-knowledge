package br.com.knowledge.capitulo1.help.generics

import br.com.concrete.canarinho.formatador.Formatador
import br.com.knowledge.widge.moneyMask
import br.com.knowledge.widge.moneyWithoutMask
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


fun main() {
    val p = "R$ 100,00"
    println(p.moneyWithoutMask())
}
