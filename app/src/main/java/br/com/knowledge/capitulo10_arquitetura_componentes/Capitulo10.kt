package br.com.knowledge.capitulo10_arquitetura_componentes

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import br.com.knowledge.R
import br.com.knowledge.capitulo8_fragment.util.LogWrapperUtil

class Capitulo10 : AppCompatActivity(), Capitulo10Contract.View{

    //presenter instanciado com o lazy
    val presenter: Capitulo10Presenter by lazy {
        Capitulo10Presenter(this, Capitulo10Interactor())
    }
    //view model example
    val viewModel:Capitulo10ViewModel by lazy {
        ViewModelProviders.of(this,
            Capitulo10ViewModelFactory(presenter))
            .get(Capitulo10ViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.capitulo10)
        lifecycle.addObserver(presenter)
        //save instance
        viewModel.callapi("23141234124214912849")
    }

    override fun responseApi() {
        LogWrapperUtil.info("aqui")
    }

}