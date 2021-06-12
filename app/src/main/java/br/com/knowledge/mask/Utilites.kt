package br.com.knowledge.widge

import android.app.Activity
import android.text.SpannableStringBuilder
import android.text.Spanned
import android.text.style.TextAppearanceSpan
import br.com.knowledge.capitulo7_mvp.SpannableLink
import java.math.BigDecimal
import java.text.DecimalFormat
import java.text.NumberFormat
import java.util.*


fun main() {
    //examplo de como usar
    val moneyDouble = 4.0
    print(moneyDouble.extensionMaskMoney())
    print("\n")
    val money = "R$ 3,00"
    print(money.extensionMoneyWithoutMask())
    print("\n")
    //só faz a máscara se tiver o ddd
    val phone = "11995726673"
    print(phone.extensionPhonePutMask())
    print("\n")
    val phoneWithMask = "(11) 99572-6673"
    print(phoneWithMask.extensionPhoneWithDrawMask())
    print("\n")
    //só faz a máscara se o cpf estiver em string
    val cpf = 72257369220
    val cnpj = "03476731000104"
    print(cpf.toString().extensionaAddMaskCpforCnpj())
    print("\n")
    //só faz a máscara se o cpnj estiver em string
    print(cnpj.extensionaAddMaskCpforCnpj())




}
//#########################################################
//                  MASK MONEY
//#########################################################
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

fun <T: Number> T.extensionMaskMoney(): String{
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


/**
 * método que tira a máscara de dinheiro da string
 *  recebe string e devolve um bigDecimal
 * @param item
 * */
inline fun <reified T:CharSequence> T.extensionMoneyWithoutMask(): BigDecimal? {
    val replaceable = java.lang.String.format("[%s,.\\s]", getCurrencySymbol())
    val cleanString = this.replace(replaceable.toRegex(), "")
    return try {
        BigDecimal(cleanString).setScale(
            2, BigDecimal.ROUND_FLOOR
        ).divide(BigDecimal(100), BigDecimal.ROUND_FLOOR)
    } catch (e: NumberFormatException) {
        //ao apagar todos valores de uma só vez dava erro
        //Com a exception o valor retornado é 0.00
        BigDecimal(0)
    }
}

fun getCurrencySymbol(): String? {
    return NumberFormat.getCurrencyInstance(Locale.getDefault()).currency.symbol
}


//#########################################################
//                  MASK PHONE
//#########################################################

/**
 * método que coloca a máscara no celular considerando o ddd
 * */
inline fun <reified T> T.extensionPhonePutMask(): T? {
    val _phone = (this as String)
        .replace("(", "")
        .replace(")", "")
        .replace("-", "")
        .replace(" ", "")
        .replace("+", "")
    if (_phone.length < 10 || _phone.length > 11) {
        return "" as T?
    }
    return if (_phone.length == 10) {
        String.format("(%s) %s-%s", _phone.substring(0, 2), _phone.substring(2, 6), _phone.substring(6, _phone.length)) as T?
    } else {
        String.format("(%s) %s-%s", _phone.substring(0, 2), _phone.substring(2, 7), _phone.substring(7, _phone.length)) as T?
    }
}

/**
 * método que tira a máscara do celular considerando o ddd
 * @return phone
 * */
inline fun <reified T> T.extensionPhoneWithDrawMask() : T? {
    val _phone = (this as String)
        .replace("(", "")
        .replace(")", "")
        .replace("-", "")
        .replace(" ", "")
        .replace("+", "")
    return  _phone as T?
}

//#########################################################
//                  ENUM GENERIC FIND
//#########################################################
/**
 * método que printa o nome de uma valor de um Enum
 * */
inline fun<reified T: Enum<T>> printValueOf(item:String): String{
    return enumValueOf<T>(item).toString()
}

/**
 * método que printa o nome de todos os valores de um Enum
 * * */
inline fun<reified T: Enum<T>> printAllValue(): String{
    return enumValues<T>().joinToString {it.name}
}

//#########################################################
//                  SPANNABLE STRING
//#########################################################

/**
 * método que concatena string com seus respectivos stilos de fontes e typefaces
 * */

inline fun  <reified T:CharSequence> T.addSpannable(font: TextAppearanceSpan, clickableSpan: SpannableLink): SpannableStringBuilder {
    val ssb = SpannableStringBuilder()
    ssb.append(this)
    ssb.setSpan(clickableSpan, 0, this.length, Spanned.SPAN_COMPOSING)
    ssb.setSpan(font, 0, this.length, Spanned.SPAN_COMPOSING)
    return ssb
}


inline fun <reified T: CharSequence> T.addSpannable(font: TextAppearanceSpan): SpannableStringBuilder {

    val ssb = SpannableStringBuilder()
    ssb.append(this)
    ssb.setSpan(font, 0, this.length, Spanned.SPAN_COMPOSING)
    return ssb
}


fun <T:String> T.extensionaAddMaskCpforCnpj(): String {

    val mask = getMask(this.length)

    var formatado = ""
    var i = 0
    // vamos iterar a mascara, para descobrir quais caracteres vamos adicionar e quando...
    for (m in mask.toCharArray()) {
        if (m != '#') { // se não for um #, vamos colocar o caracter informado na máscara
            formatado += m
            continue
        }
        // Senão colocamos o valor que será formatado
        try {
            formatado += this[i]
        } catch (e: Exception) {
            break
        }

        i++
    }
    return formatado
}

fun getMask(length: Int): String {
    return if(length == 11) "###.###.###-##" else "##.###.###/####-##"
}



