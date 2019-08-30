package br.com.knowledge.capitulo7_mvp

import android.os.Handler
import java.lang.Exception

class MainPresenter(val mView: MainContract.View, val interactor :MainContract.Interactor){

    fun loadLIst(teste: String) {
        mView.showProgress()
        try {
            interactor.loadList(teste, object : MainContract.Callback{
                override fun onLoadList(result: ArrayList<String>) {
                    mView.hideProgress()
                    Handler().postDelayed({
                        //doSomethingHere()
                        mView.loadList(result)
                    }, 2000)

                }
            })
        }catch (e: Exception){
            mView.hideProgress()
            mView.errorHttp()
        }
    }


}