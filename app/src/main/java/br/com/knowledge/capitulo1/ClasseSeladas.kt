package br.com.knowledge.capitulo1

import android.util.Log
import java.lang.Exception


sealed class Operation {
    class Add(val value: Int) : Operation()
    class Substract(val value: Int) : Operation()
    class Multiply(val value: Int) : Operation()
    class Divide(val value: Int) : Operation()
    //object Increment : Operation()
    //object Decrement : Operation()
}

fun execute(x: Int, op: Operation) = when (op) {
    is Operation.Add -> x + op.value
    is Operation.Substract -> x - op.value
    is Operation.Multiply -> x * op.value
    is Operation.Divide -> x / op.value
    //Operation.Increment -> x + 1
    //Operation.Decrement -> x - 1
}


//return success or error api
sealed class Result<out T: Any>{
    data class Success<out T: Any>(val data: T): Result<T>()
    sealed class Error(val exception: Exception): Result<Nothing>(){
        class ExpiredSession(exception: Exception):Error(exception)
        class ServerError(exception: Exception):Error(exception)
        class Enhance(exception: Exception):Error(exception)

    }

}

fun execute2(result: Result<Any>) = when(result){
    is Result.Success->{    
        Log.i("sucess", "${result.data}")
    }
    is Result.Error.ExpiredSession->{
        Log.i("error", "${result.exception}")
    }
    is Result.Error.ServerError->{}
    is Result.Error.Enhance->{}

}

data class Enzo(var name:String, var age:Int)


fun main(){
    //execute(2, Operation.Substract(2))
    //var e = Enzo("Enzo", 37)
    //execute2(Result.Success(e))

    val e = Exception()


    execute2(Result.Error.ServerError(e))

}