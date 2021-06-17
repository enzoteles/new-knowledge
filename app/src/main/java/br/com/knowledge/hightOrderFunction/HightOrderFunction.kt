package br.com.knowledge.hightOrderFunction

fun addTwoNumber(a:Int, b:Int) : Int{
    return  a + b
}

val somaTwoNumber : (Int, Int) -> Int = {a:Int, b:Int -> a + b}

fun listPessoa(list: List<Pessoa>) : List<Pessoa>{
    return list
}

val listPessoaTwo: (List<Pessoa>) -> List<Pessoa> = {list : List<Pessoa> -> list}

fun operation(): (Int)-> Int {
    return ::square
}

fun square(x:Int) = x * x


fun main() {
    /*print(addTwoNumber(2,3))
    print("\n")
    print(somaTwoNumber(3,4))*/




    val list = listPessoaTwo(listOf(
        Pessoa(1, "sim"),
        Pessoa(2, "não")
    ))

    print(list)



}

data class Pessoa(val age:Int, val name:String)


