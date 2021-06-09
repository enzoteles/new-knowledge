package br.com.knowledge.biulder

import android.util.Log


fun main(){

    EnzoTeles()
        .setWoman("Daniele")
        .setAge(38)
        .build {
            println("$it")
        }


}


class EnzoTeles{
    var age: Int ?= null
    var woman: String?= null


    fun setWoman(woman:String): EnzoTeles {
        this.woman = woman
        return this
    }
    fun setAge(age:Int): EnzoTeles {
        this.age = age
        return this
    }

    //a função inline cria uma cópia do método , diferente da função comum que cria um objeto na memória
    inline fun build(crossinline result: (String) -> Unit){
        val task =  Runnable {
            if(this.age!! == 37 )result("Enzo Teles") else result("Teles")
        }
        task.run()
    }

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