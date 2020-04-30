package br.com.knowledge.capitulo10_arquitetura_componentes

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import br.com.knowledge.R
import br.com.knowledge.capitulo8_fragment.util.LogWrapperUtil
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf
import java.util.*

class Capitulo10 : AppCompatActivity(), Capitulo10Contract.View{

    var ac = 1
    val presenter: Capitulo10Presenter by inject {
        parametersOf(this)
    }
    //presenter instanciado com o lazy
   /* val presenter: Capitulo10Presenter by lazy {
        Capitulo10Presenter(this, Capitulo10Interactor())
    }*/
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

        for(ac in 1..6){
            this.ac += this.ac + 1
            var string = (1..60).random()
            LogWrapperUtil.info("aqui===> $string")
        }

    }


    fun ClosedRange<Int>.random() =
        Random().nextInt(endInclusive - start) +  start

}