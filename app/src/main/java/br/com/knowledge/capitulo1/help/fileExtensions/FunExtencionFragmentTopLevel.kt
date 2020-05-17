package br.com.knowledge.capitulo1.help.fileExtensions

import android.os.Bundle

//Example with fragment
fun FunExtencionFragment.Companion.newInstance(id: Int) = FunExtencionFragment()
    .apply {
        this.arguments = Bundle().apply {
            putInt(ID_CODE, id)
        }
    }

const val ID_CODE = "ID_CODE"




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
