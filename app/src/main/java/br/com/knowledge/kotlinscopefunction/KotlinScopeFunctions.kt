package br.com.knowledge.kotlinscopefunction


class Jogador {
    var nome: String? = null
    var numeroCamisa: Int? = null
    var isCheck: String? = null
    var age: Int? = null
}

fun main() {
    val jogador = Jogador().apply {
        this.nome = "enzo"
        this.numeroCamisa = 1
    }

    jogador?.let {
        with(it){
            this.also { jog->
                //also troca o objeto
                jog.nome = "daniele"
                print(jog.nome)
            }
        }
    }

    //substitue o if/else
    var sim = (jogador.isCheck?.let { it } ?: run { "ee" }).apply {
        print(this)
    }

    var idade = (jogador.age?.let { it } ?: run { 32 }).apply { print(this) }


}


//apply == set
//with == get
// let != null
// also == change object

