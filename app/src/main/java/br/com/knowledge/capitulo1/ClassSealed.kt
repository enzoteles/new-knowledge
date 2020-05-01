package br.com.knowledge.capitulo1

import java.lang.Exception

//return success or error api
sealed class Result<out T: Any>{
    data class Success<out T: Any>(val data: T): Result<T>()
    sealed class Error(val exception: Exception): Result<Nothing>(){
        class ExpiredSession(exception: Exception):Error(exception)
        class ServerError(exception: Exception):Error(exception)
        class Enhance(exception: Exception):Error(exception)
    }
}