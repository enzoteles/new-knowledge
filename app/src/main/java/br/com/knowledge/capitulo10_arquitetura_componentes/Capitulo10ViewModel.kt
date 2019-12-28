package br.com.knowledge.capitulo10_arquitetura_componentes

import androidx.lifecycle.*
import br.com.knowledge.capitulo8_fragment.util.LogWrapperUtil
import java.lang.IllegalArgumentException


class Capitulo10ViewModel(val prest: Capitulo10Contract.Presenter) : ViewModel(){

    fun callapi(token: String) {
       prest.callapi(token)
    }
}


/**
 * classe criada quando o viewmodel recebe parametros no construtor
 * @param viewModel
 * */
class Capitulo10ViewModelFactory(private val presenter:Capitulo10Contract.Presenter): ViewModelProvider.Factory{

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(Capitulo10ViewModel::class.java)){
            return Capitulo10ViewModel(presenter) as T
        }
        throw  IllegalArgumentException("View Model inválido")
    }

}


