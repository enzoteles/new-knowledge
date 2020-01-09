package br.com.knowledge.capitulo10_arquitetura_componentes

import android.app.Application
import org.koin.android.ext.android.startKoin


class MainApplication : Application(){

    override fun onCreate() {
        super.onCreate()
        startKoin(this, listOf(appCap10))
    }

}