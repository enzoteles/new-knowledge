package br.com.knowledge.generics

class ClassGenerics2 {

    val list = arrayListOf(
        1 to "Cielo",
        2 to "Rede",
        3 to "Mercado"
    )



}

fun <K: Int, V: String> List<Pair<K, V>>.selectNumberImpar(): List<Pair<K, V>>{

    val listImpar = ArrayList<Pair<K, V>>()

    this.forEach {
        if(it.first % 2 == 1){
            listImpar.add(it)
        }
    }

    return listImpar

}

fun main() {
    ClassGenerics2().apply {
        print(list.selectNumberImpar())
    }
}



