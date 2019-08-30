package br.com.knowledge.capitulo7_mvp

interface MainContract{

    interface View{
        fun showProgress()
        fun hideProgress()
        fun errorHttp()
        fun loadList(result: ArrayList<String>)
    }
    interface Interactor{
        fun loadList(teste:String, callback:Callback)
    }

    interface Callback{
        fun onLoadList(result: ArrayList<String>)
    }
}