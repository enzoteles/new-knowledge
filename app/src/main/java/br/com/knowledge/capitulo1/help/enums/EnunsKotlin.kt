package br.com.knowledge.capitulo1.help.enums

import android.provider.Settings
import androidx.core.content.ContextCompat
import br.com.knowledge.R
import br.com.knowledge.widge.printAllValue
import br.com.knowledge.widge.printValueOf
import kotlinx.android.synthetic.main.capitulo8_hotel_details.*


fun main(){

    println(printAllValue<RGB>())

    println(printValueOf<RGB>("PINK"))



}

enum class RGB{
    BLUE,GREEN,YELLOW, PINK
}
