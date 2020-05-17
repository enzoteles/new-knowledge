package br.com.knowledge.capitulo1.help.fileExtensions


fun main(){

    val list = mutableListOf<Float>(1.7f,2.4f,3.3f,4.0f,5f).int(310, 3){
        println("$it")
    }
    val x = mutableListOf<Int>(9,3,4).first()
    println("$x")

}

//extension with variable
var MutableList<Int>.first: Int
    get() = this[0]
    set(value) {this[0] = value}

//extension with methdo
fun MutableList<Int>.swap (index1: Int, index2:Int){
    val tmp = this[index1]
    this[index1] = this[index2]
    this[index2] = tmp
}

//extension with generics
fun <T>MutableList<T>.int (index1: Int, index2:Int, callback: (Int) -> Unit){
    var tmp = 0
    if(index1 > index2){
        tmp = index1
        callback(tmp)
    }else{
        tmp = index2
        callback(tmp)
    }
}

class FunctionsExtensionKotlin (){
    companion object{}
}


//extension with object companion
fun FunctionsExtensionKotlin.Companion.strintName() = "Sim"

//extension with class
fun FunctionsExtensionKotlin.scopeOfExtension() = 1

