package br.com.knowledge.capitulo1.help.innerClass

import android.provider.Settings.Global.getString
import android.text.SpannableStringBuilder
import android.text.style.TextAppearanceSpan
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentHostCallback
import br.com.knowledge.R
import br.com.knowledge.capitulo7_mvp.SpannableLink
import br.com.knowledge.widge.moneyMask

/**
 * quando coloca a palavra reservada inner em uma classes
 * essa classe é capaz de acessar todos os atributos da outra classe
 * */


fun main(){

    println("=========== " + caoBrabo())
}


/**
 * esse é um exemplo de 'anonymous inner class'
 * */
interface Action{
    fun latir(): String
}

fun caoBrabo(): String{

    val mLatir : Action = object : Action{
        override fun latir(): String {
            return "au au au"
        }
    }
    return mLatir.latir()
}





