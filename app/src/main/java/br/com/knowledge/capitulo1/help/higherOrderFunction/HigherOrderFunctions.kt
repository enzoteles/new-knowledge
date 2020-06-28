package br.com.knowledge.capitulo1.help.higherOrderFunction



class HigherOrderFunctions{

    //método usando o hide order function
    fun subtrair(a:Int, b:Int, result: (Int)-> Unit){
        var res = a - b
        result(res)
    }


    fun nameAluno(name:String, age:Int, result:(String)-> Unit){
        var concatenar = "$name - $age"
        result.invoke(concatenar)
    }

}



fun main() {

    val h = HigherOrderFunctions()
    //usando hide order function
    h.subtrair(10,2){
        println("o resulta é $it")
    }

    h.nameAluno("Enzo", 38){
        println("$it")
    }

}

