package br.com.knowledge.capitulo10_arquitetura_componentes

class Capitulo10Interactor: Capitulo10Contract.Interactor{

    override fun callapi(
        token: String,
        presenter:  Capitulo10Contract.Presenter
    ) {
        presenter.responseApi()
    }
}