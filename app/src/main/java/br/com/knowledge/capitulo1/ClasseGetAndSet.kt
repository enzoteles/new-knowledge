package br.com.knowledge.capitulo1

import android.view.View
import androidx.fragment.app.Fragment


internal class ClasseGetAndSet:Fragment(){

    internal  var isCheck : Boolean = false
        get() = field

    var statusView: Int = View.GONE
        get() = field


}

fun main(){

    val c = ClasseGetAndSet()
    var sim = false
    if(sim){
        c.statusView = View.VISIBLE
    }else{
        c.statusView = View.INVISIBLE
    }

    //println(c.isCheck)



}