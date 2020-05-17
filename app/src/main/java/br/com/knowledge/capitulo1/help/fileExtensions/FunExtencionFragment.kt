package br.com.knowledge.capitulo1.help.fileExtensions

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import br.com.knowledge.R

class FunExtencionFragment() : Fragment() {

    var id: Int? = null

    companion object{}

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.capitulo2, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        this.arguments?.let {
            id = it.getInt(ID_CODE)
            Log.i("FUN", "$id")
        }
    }

}


fun FunExtencionFragment.Companion.newInstance(id: Int) = FunExtencionFragment()
    .apply {
    this.arguments = Bundle().apply {
        putInt(ID_CODE, id)
    }
}

const val ID_CODE = "ID_CODE"

