package br.com.myapp

interface OnMainPresenter{
    interface View{
        fun showResponse()
    }
    interface Presenter<V,R>{
        fun initView(view:V, repo:R)
        fun loadName()
    }
    interface Repository
}