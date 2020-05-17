package br.com.knowledge.capitulo1.help.fileExtensions


fun main(){

    val list = mutableListOf<Float>(1.7f,2.4f,3.3f,4.0f,5f).int(310, 3){
        println("$it")
    }
    val x = mutableListOf<Int>(9,3,4).first()
    println("$x")

}


class FunctionsExtensionKotlin (){
    companion object{}
}


//extension with object companion
fun FunctionsExtensionKotlin.Companion.strintName() = "Sim"

//extension with class
fun FunctionsExtensionKotlin.scopeOfExtension() = 1

