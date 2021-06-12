package br.com.knowledge.generics

data class PropertsGenerics<F: Any?, S: Any?, T: Any?, O: Any?>(
    var first: F ,
    var second: S,
    var third: T,
    var fourth: O
)


fun main() {

    val gen = PropertsGenerics(1, "Enzo", "Teles", 38)
    val gen1 = PropertsGenerics(1, "Enzo", "Teles", 38)

    val list = ArrayList<PropertsGenerics<Int, String, String, Int>>()
    list.add(gen)
    list.add(gen1)

    list.forEach{
        print(it.second)
        print(it.fourth)
    }

}


