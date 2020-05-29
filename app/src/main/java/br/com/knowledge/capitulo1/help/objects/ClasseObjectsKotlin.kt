package br.com.knowledge.capitulo1.help.objects

import java.util.*

fun main(){

   /* var dayOrNight = object{
        val day = "good morning"
        val night = "good night"
    }

    println(dayOrNight.day)
    println(dayOrNight.night)*/

    /*val testeAnomimos = TesteAnomimos()
    testeAnomimos.testeAnominos()

    println(TesteAnomimos.getNameAnonimous())*/

    val listB = listOf("enzo", "teles", "sofia", "teles")
    val list2 = listB.subList(0,2)

    println(list2.size)





}


abstract class Dog(){
    abstract fun toEat(): String
}


class TesteAnomimos(){

    fun printDog(dog: Dog){
        println(dog)
    }

    companion object{}

    val latir = printDog(object : Dog(){
        override fun toEat(): String {
            TODO("Not yet implemented")
        }
    })

    fun testeAnominos(){
        TesteRepo.loadCall()
    }

}


interface OnRepository{
    fun loadCall()
}

//object pode ser usando como o singleton e pode ter também superclasse
object TesteRepo: OnRepository {

    override fun loadCall() {
        println("load call")
    }

}

//como o compaion object podemos fazer facilmente métodos ou variável em top level.
fun TesteAnomimos.Companion.getNameAnonimous() = "Name"



