package br.com.knowledge.capitulo1



fun main(){

    var cal = CalculadoraImp()
    //usando função lambda
    cal.soma(10, 20, object :Calculadora{
        override fun resultSoma(result: Int) {
            println("a soma é $result")
        }
    })

    //usando hide order function
    cal.subtrair(10,2){
        println("o resulta é $it")
    }


}

class CalculadoraImp{
    //método usando lambda
    fun soma(a: Int, b: Int, calculadora: Calculadora){
        var result = a + b
        calculadora.resultSoma(result)
    }

    //método usando o hide order function
    fun subtrair(a:Int, b:Int, result: (Int)-> Unit){
        var res = a - b
        result(res)
    }
}

interface Calculadora{
    fun resultSoma(result: Int)
}


