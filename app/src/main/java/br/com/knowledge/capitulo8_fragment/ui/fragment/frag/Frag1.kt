package br.com.knowledge.capitulo8_fragment.ui.fragment.frag

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import br.com.knowledge.R
import br.com.knowledge.capitulo8_fragment.domain.Hotel
import br.com.knowledge.capitulo8_fragment.util.FragmentManagerUtil
import kotlinx.android.synthetic.main.frag1.*

class Frag1 : Fragment(), FragContract.Frag1View{

    private val presenter = FragPresenter(this)
    var listener: onHotelListener ?= null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.frag1, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btn_frag.setOnClickListener {
            val hotel = Hotel(1, "show frag1", "rua j", 2.0f)
            presenter.sendHotel(hotel)

        }
    }

    override fun showHotel(hotel: Hotel) {

        FragmentManagerUtil.apply {
            replaceFragment(R.id.content_capitulo8, Frag2.newInstance(hotel.name).apply {
                listener = this
            }, Frag2.TAG_NAME, true, requireActivity().supportFragmentManager)
        }

        listener?.onClickHotel(hotel)
    }

    interface onHotelListener{
        fun onClickHotel(hotel: Hotel)
    }
}