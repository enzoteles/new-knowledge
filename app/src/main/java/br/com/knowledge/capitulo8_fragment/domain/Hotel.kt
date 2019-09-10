package br.com.knowledge.capitulo8_fragment.domain

data class Hotel(
    var id:Long = 0,
    var name:String = "",
    var address:String = "",
    var rating: Float = 0.0f
){
    override fun toString() = name
}