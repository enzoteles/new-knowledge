package br.com.knowledge.capitulo1.help.innerClass

import br.com.knowledge.widge.moneyMask
import br.com.knowledge.widge.moneyWithoutMask
import br.com.knowledge.widge.phonePutMask
import br.com.knowledge.widge.phoneWithDrawMask


val stringPlus: (String, String) -> String = String::plus
val intPlus: Int.(Int) -> Int = Int::plus


fun main(){

   /* println(stringPlus.invoke("<-", "->"))
    println(stringPlus("Hello, ", "world!"))

    println(intPlus.invoke(1, 1))
    println(intPlus(1, 2))
    println(2.intPlus(3))*/

    val mask = 300
    println(mask.moneyMask())

}


//parametro crossinline
inline fun f(crossinline body: () -> Unit) {
    val f = object: Runnable {
        override fun run() = body()
    }
    // ...
}

