package br.com.knowledge.capitulo2_laoyout

import android.os.Bundle
import android.view.ViewGroup
import android.view.LayoutInflater
import android.view.View
import android.widget.ListView
import androidx.fragment.app.Fragment
import br.com.knowledge.R
import kotlinx.android.synthetic.main.capitulo2_fragment_list.*


class FragmentA : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.capitulo2_fragment_list, container, false)
        val stringList = ArrayList<String>()

        stringList.add("Item 1A")
        stringList.add("Item 1B")
        stringList.add("Item 1C")
        stringList.add("Item 1D")


        return view
    }

}

