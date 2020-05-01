package br.com.knowledge.capitulo1

interface ApiCallbackRest<RESPONSE, ERROR>{
    fun onSuccess(response: RESPONSE)
    fun onErrorSessionExpired(error: ERROR)
    fun onErrorServerError(error: ERROR)
    fun onErrorEnhance(error: ERROR)
}


