package br.com.knowledge.capitulo1.help.function


fun main(){
    println(testeInfix())
}

/**
 * pode chamar o infix
 * função de extensão
 * se tiver um unico parametro
 * marcar uma palavra como keyboard
 * */
fun testeInfix(): String{
    infix fun Int.add(x: Int): Int{return this + x}
    return "add 4 to 5 = ${5.add(4)}"

}