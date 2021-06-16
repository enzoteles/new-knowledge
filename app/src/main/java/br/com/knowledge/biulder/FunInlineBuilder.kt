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
    // a palavra crossinline é para poder usar uma hight order function como parâmetro
    inline fun build(crossinline result: (String) -> Unit){
        val task =  Runnable {
            if(this.age == 37 )result("Enzo Teles") else result("Teles")
        }
        task.run()
    }

}


