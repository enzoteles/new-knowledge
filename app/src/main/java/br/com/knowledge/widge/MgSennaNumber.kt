package br.com.knowledge.widge

import java.util.*

fun main(){
    println("teste")
    val list = getRandomNonRepeatingIntegers(6, 0, 60)
    for (i in 0 until list!!.size) {
        System.out.println("" + list!![i])
    }
}


fun getRandomInt(min: Int, max: Int): Int {
    val random = Random()
    return random.nextInt(max - min + 1) + min
}

fun getRandomNonRepeatingIntegers(
    size: Int, min: Int,
    max: Int
): ArrayList<Int>? {
    val numbers = ArrayList<Int>()
    while (numbers.size < size) {
        val random = getRandomInt(min, max)
        if (!numbers.contains(random)) {
            numbers.add(random)
        }
    }
    return numbers
}

