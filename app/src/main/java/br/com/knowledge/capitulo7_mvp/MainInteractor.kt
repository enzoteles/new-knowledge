package br.com.knowledge.capitulo7_mvp

import android.util.Log


class MainInteractor: MainContract.Interactor{

    override fun loadList(teste: String, callback: MainContract.Callback) {
        val arrayList = arrayListOf<String>("enzo", "dani")
        callback.onLoadList(arrayList)
    }

}