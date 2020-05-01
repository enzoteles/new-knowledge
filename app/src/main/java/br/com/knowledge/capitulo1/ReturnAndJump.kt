package br.com.knowledge.capitulo1

import android.util.Log

fun main(){

    var call = CallPresenter()
    var name = "enzo"
    call.verification(name, object : ApiCallbackRest<Any, Any>{

        override fun onSuccess(response: Any) {
            executeShow(Result.Success(response))
        }

        override fun onErrorEnhance(error: Any) {
            //executeShow(Result.Error.Enhance(exception = error))
        }

        override fun onErrorServerError(error: Any) {
            //executeShow(Result.Error.ServerError(exception = error))
        }

        override fun onErrorSessionExpired(error: Any) {
            //executeShow(Result.Error.ExpiredSession(exception = error))
        }


    })

}

fun executeShow(result: Result<Any>) = when(result){
    is Result.Success->{
        Log.i("sucess", "${result.data}")
    }
    is Result.Error.ExpiredSession->{
        Log.i("error", "${result.exception}")
    }
    is Result.Error.ServerError->{}
    is Result.Error.Enhance->{}

}




