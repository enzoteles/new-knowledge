package br.com.knowledge.capitulo10_arquitetura_componentes

import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module.module

val appCap10 = module {
    factory(name = "capitulo10koin") { (view: Capitulo10Contract.View) ->
        Capitulo10Presenter(view, Capitulo10Interactor())
    }
}