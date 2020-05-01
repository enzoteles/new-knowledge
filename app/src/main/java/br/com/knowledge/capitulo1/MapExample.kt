package br.com.knowledge.capitulo1

fun main(){


    var carro1 = Triple(1, "corsa", false)
    var carro2 = Triple(2, "fusca", true)



    var listPar = listOf(carro1, carro2)

    for (c in listPar){
        println(c.third)
    }




}