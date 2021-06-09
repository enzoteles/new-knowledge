package br.com.knowledge.capitulo1.help.inlinefunctions

import android.util.Log


fun main(){

    /*EnzoTeles(36)
        .woman("Daniele")
        .build {
            println("$it")
        }*/

    Log.i("Enzo", "teles")

}


class EnzoTeles(age: Int){
    var age: Int ?= null
    var woman: String?= null


    init {
        this.age = age
    }

    fun woman(woman:String): EnzoTeles {
        this.woman = woman
        return this
    }

    //o inline é usada quando temos uma funçao sendo passada por parametro
    inline fun build(result: (String) -> Unit){ if(this.age == 37 )result("Enzo Teles") else result("Teles")}

}


val s = fun(a: Int, b: Int, result: (Int) -> Unit) {
    result(a+b)
}


inline fun fullName(name: String, sobrenome: String, result: (String) -> Unit){
    result("$name - $sobrenome")
}


/*//parametro crossinline
inline fun f(crossinline body: () -> Unit) {
    val f = object: Runnable {
        override fun run() = body()
    }
    // ...
}*/