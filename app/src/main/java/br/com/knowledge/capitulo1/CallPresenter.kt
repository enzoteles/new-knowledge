package br.com.knowledge.capitulo1

class CallPresenter {

    fun verification(name: String, calback: ApiCallbackRest<Any, Any>) {


        var response = UserResponse("enzo", 37)

        var error = UserError("server error")

        calback.onSuccess(response)
        //calback.onErrorSessionExpired(error)
    }

}

data class UserResponse(var name: String, var age: Int)
data class UserError(var error: String)
