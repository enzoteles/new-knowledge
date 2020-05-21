package br.com.knowledge.widge

import java.lang.IllegalArgumentException
import java.lang.NumberFormatException
import java.math.BigDecimal
import java.text.DecimalFormat
import java.text.NumberFormat
import java.util.*

/**
 * esse método coloca mascara de dinheiro em real
 * método só pode receber valores tipo:
 * int, float, double, bigdecimal etc.
 * nunca string
 * @param item
 * */
fun <T> maskMoney(item: T): String{
    return "R$ ${item.extensionMaskMoney()}"
}

fun <T> T.extensionMaskMoney(): String{

    val _brFormat = NumberFormat.getCurrencyInstance(Locale("pt", "BR"))
            as DecimalFormat
    _brFormat.minimumFractionDigits = 2
    val decimalFormatSymbols = _brFormat.decimalFormatSymbols
    decimalFormatSymbols.currencySymbol = ""

    _brFormat.decimalFormatSymbols = decimalFormatSymbols

    return _brFormat.format(this).trim()
}
//#########################################################

/**
 * método que tira a máscara de dinheiro da string
 *  recebe string e devolve um bigDecimal
 * @param item
 * */

fun <T> withDrawMaskMoney(item: T): BigDecimal {
    return item.toString().extensionWithDrawMaskMoney()
}

fun <T> T.extensionWithDrawMaskMoney(): BigDecimal {

    val ptBrFormat = NumberFormat.getCurrencyInstance(Locale("pt", "BR"))
    ptBrFormat.minimumFractionDigits = 2

    try {
        return BigDecimal.valueOf(ptBrFormat.parse(this.toString()).toDouble())
    } catch (ex: NumberFormatException) {
        throw IllegalArgumentException()
    }
}