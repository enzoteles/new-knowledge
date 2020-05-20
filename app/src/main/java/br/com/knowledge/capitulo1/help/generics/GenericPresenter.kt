package br.com.knowledge.capitulo1.help.generics

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

/**
 * Classe Fragment
 * */
class GenericFragment: Fragment(), MVP.View{

    val genericPresenter: GenericPresenter<MVP.View, MVP.Repository>
          get() = GenericPresenter(this, GenericRepository())

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun callApi() {
        genericPresenter.callApi()
    }

    override fun responseApi() {
        Log.i("LOG","Generics")
    }

    override fun initView() {
    }

    override fun loadParams() {
    }
}
/**
 * Classe Presenter Genérico
 * */
class GenericPresenter<V, R>(
    var mView: MVP.View,
    var mRepository: MVP.Repository
) {

    fun callApi(){
        mRepository.requestApi(){
            mView.responseApi()
        }
    }

}
/**
 * Classe Repository
 * */
class GenericRepository() : MVP.Repository{
    override fun requestApi(callback: (String)-> Unit) {
        callback("teste")
    }

}

interface OnGenericView{
    fun initView()
    fun loadParams()
}

interface MVP{
    interface View: OnGenericView{
        fun callApi()
        fun responseApi()
    }
    interface Repository{
        fun requestApi(callback: (String)-> Unit)
    }
}