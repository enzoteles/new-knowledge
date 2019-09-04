package br.com.knowledge.capitulo3_activity_intent

import java.text.DecimalFormat
import java.text.NumberFormat
import java.util.*

fun Double.toPtBrRealString(): String {
    val ptBrFormat =  this.toPtBrRealStringWithoutSymbol()
    return "R$ $ptBrFormat"
}

fun Double.toPtBrRealStringWithoutSymbol(): String {
    val ptBrFormat = NumberFormat.getCurrencyInstance(Locale("pt", "BR"))
            as DecimalFormat
    ptBrFormat.minimumFractionDigits = 2
    val decimalFormatSymbols = ptBrFormat.decimalFormatSymbols
    decimalFormatSymbols.currencySymbol = ""

    ptBrFormat.decimalFormatSymbols = decimalFormatSymbols

    return ptBrFormat.format(this).trim()
}