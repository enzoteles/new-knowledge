package br.com.myapp


class MainPresenterGenerics<V,R> : OnMainPresenter.Presenter<V,R>{
    var view:V ?= null
    var repo:R ?= null
    var itemInteface: OnclickListenerSAM ?= null

    interface OnclickListenerSAM{
        fun execute()
    }

    override fun initView(view: V, repo: R) {
        this.view = view
        this.repo = repo
    }

    override fun loadName() {
        (this.view as OnMainPresenter.View).showResponse()
    }
}


