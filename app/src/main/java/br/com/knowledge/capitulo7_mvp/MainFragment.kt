package br.com.knowledge.capitulo7_mvp

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager

import br.com.knowledge.R
import kotlinx.android.synthetic.main.fragment_main.*

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class MainFragment : Fragment(), MainContract.View {


    lateinit var adapter: BandeieraAdapter
    var listBandeiras = ArrayList<Bandeiras>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
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



        var bandeira = Bandeiras("BANCO BRADESCO S/A", "https://digitalhml.hdevelo.com.br/merchant/solutions/static/assets/img/brands/brand_15.png")
        var bandeira1 = Bandeiras("BANCO BRADESCO S/A", "https://pbs.twimg.com/profile_images/2227101468/enzo_400x400.jpg")
        var bandeira2 = Bandeiras("BANCO BRADESCO S/A", "https://digitalhml.hdevelo.com.br/merchant/solutions/static/assets/img/brands/brand_7.png")
        listBandeiras.add(bandeira)
        listBandeiras.add(bandeira1)
        listBandeiras.add(bandeira2)

        adapter = BandeieraAdapter(listBandeiras, requireContext())
        rv_bandeiras.layoutManager = GridLayoutManager(context, 2)
        rv_bandeiras.adapter = adapter

    }

    override fun showProgress() {
    }

    override fun hideProgress() {
    }

    override fun errorHttp() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun loadList(result: ArrayList<String>) {
        Log.i("testes", "teste")
    }
}
