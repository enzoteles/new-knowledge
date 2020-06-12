package br.com.knowledge.capitulo1.help.delegate

import android.util.Log
import android.widget.Toast
import br.com.knowledge.capitulo3_activity_intent.User
import br.com.knowledge.capitulo8_fragment.util.LogWrapperUtil
import kotlin.reflect.KProperty


/**
 * delegate é bom para herança de classes
 * */

class Example(){

    var _pavavra: String by Delegate()
    lateinit var _user : User


}

class Delegate(){

    operator fun getValue(thisRef:Any?, property: KProperty<*>) : String{
        return "$thisRef, thank you for delegating '$property' to me"
    }

    operator fun setValue(thisRef: Any?,property: KProperty<*>, value: String){
        Log.d("delagete","$value - ${property.name} -  $thisRef")
    }

}

fun main() {
    val e = Example()
    e._pavavra = "NEW"
    println(e._pavavra)
}

