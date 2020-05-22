package br.com.knowledge.widge

import java.lang.IllegalArgumentException
import java.lang.NumberFormatException
import java.math.BigDecimal
import java.text.DecimalFormat
import java.text.NumberFormat
import java.util.*

/**
 * esse método coloca mascara de dinheiro em real
 * método só pode receber valores  que estão abaixo de Number, tipo:
 * int, float, double, bigdecimal etc.
 * nunca string
 * @param item
 * */
fun <T: Number> T.moneyMask(): String{
        return "R$ ${extensionMaskMoney()}"
}

private fun <T: Number> T.extensionMaskMoney(): String{
    val _brFormat = NumberFormat.getCurrencyInstance(Locale("pt", "BR"))
            as DecimalFormat
    _brFormat.minimumFractionDigits = 2
    val decimalFormatSymbols = _brFormat.decimalFormatSymbols
    decimalFormatSymbols.currencySymbol = ""
    _brFormat.decimalFormatSymbols = decimalFormatSymbols
    try{
        return _brFormat.format(this).trim()
    }catch (ex: NumberFormatException) {
        throw IllegalArgumentException()
    }

}
//#########################################################

/**
 * método que tira a máscara de dinheiro da string
 *  recebe string e devolve um bigDecimal
 * @param item
 * */


fun <T: Any> T.moneyWithoutMask(): BigDecimal {
    val _brFormat = NumberFormat.getCurrencyInstance(Locale("pt", "BR"))
    _brFormat.minimumFractionDigits = 2
    try {
        return BigDecimal.valueOf(_brFormat.parse(this.toString()).toDouble())
    } catch (ex: NumberFormatException) {
        throw IllegalArgumentException()
    }
}
//#########################################################

/**
 * método que coloca a máscara no celular considerando o ddd
 * */
fun <T: Any> T.phonePutMask(): String {
    val phone = this.toString()
        .replace("(", "")
        .replace(")", "")
        .replace("-", "")
        .replace(" ", "")
        .replace("+", "")
    if (phone.length < 10 || phone.length > 11) {
        return ""
    }
    return if (phone.length == 10) {
        String.format("(%s) %s-%s", phone.substring(0, 2), phone.substring(2, 6), phone.substring(6, phone.length))
    } else {
        String.format("(%s) %s-%s", phone.substring(0, 2), phone.substring(2, 7), phone.substring(7, phone.length))
    }
}

/**
 * método que tira a máscara do celular considerando o ddd
 * */
fun <T: Any> T.phoneWithDrawMask() : String {
    val phone = this.toString()
        .replace("(", "")
        .replace(")", "")
        .replace("-", "")
        .replace(" ", "")
        .replace("+", "")
    return  phone
}