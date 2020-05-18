package br.com.knowledge.capitulo1.help.sealedClasse

import android.util.Log
import br.com.knowledge.capitulo1.help.dataClasses.Casa

data class ErrorHandle(val codeError: Int, val msg: String)

/**
 * classes seladas tem seus construtores privados por default
 * não podem ser instanciadas, é uma classa abstrata por ela mesma
 * */

sealed class CallBackResponse{
    data class Sucess(val data:Any) : CallBackResponse()
    data class Error(val codeError: Int, val msg: String) : CallBackResponse()
    object Progress : CallBackResponse()
}

fun execute(callback : CallBackResponse) = when(callback){
    is CallBackResponse.Sucess-> println("${callback.data}")
    is CallBackResponse.Error-> println("${callback.codeError} -- ${callback.msg}")
    is CallBackResponse.Progress-> println("progress...")
}


fun main(){

    execute(CallBackResponse.Sucess(Casa("minha casa", 37)))
    val error = ErrorHandle(400, "tente novamente")
    execute(CallBackResponse.Error(error.codeError, error.msg))

    execute(CallBackResponse.Progress)



}