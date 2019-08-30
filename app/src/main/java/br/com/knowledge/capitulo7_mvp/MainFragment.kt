package br.com.knowledge.capitulo7_mvp

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import br.com.knowledge.R
import kotlinx.android.synthetic.main.capitulo3.*
import kotlinx.android.synthetic.main.fragment_main.*

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class MainFragment : Fragment(), MainContract.View {

    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    val presenter = MainPresenter(this, MainInteractor())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.loadLIst("testse")

    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            MainFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    override fun showProgress() {
        button_man.visibility = View.GONE
        progress.visibility = View.VISIBLE
    }

    override fun hideProgress() {
        button_man.visibility = View.VISIBLE
        progress.visibility = View.GONE
    }

    override fun errorHttp() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun loadList(result: ArrayList<String>) {
        Log.i("testes", "teste")
    }
}
