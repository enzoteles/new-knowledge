package br.com.knowledge.capitulo10_arquitetura_componentes

interface Capitulo10Contract {

    interface View {
        fun responseApi()
    }

    interface Presenter {
        fun callapi(token: String)
        fun responseApi()
    }

    interface Interactor {
        fun callapi(
            token: String,
            presenter: Presenter
        )
    }
}