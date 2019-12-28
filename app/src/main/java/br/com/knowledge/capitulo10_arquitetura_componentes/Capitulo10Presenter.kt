package br.com.knowledge.capitulo10_arquitetura_componentes

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import br.com.knowledge.capitulo8_fragment.util.LogWrapperUtil

class Capitulo10Presenter(
    val view: Capitulo10Contract.View,
    val interactor: Capitulo10Interactor
) : Capitulo10Contract.Presenter, LifecycleObserver {

    override fun callapi(token: String) {
        interactor.callapi(token, this)
    }

    override fun responseApi() {
        view.responseApi()
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun start() {
        LogWrapperUtil.info("start")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun destroy() {
        LogWrapperUtil.info("destroy")
    }

}