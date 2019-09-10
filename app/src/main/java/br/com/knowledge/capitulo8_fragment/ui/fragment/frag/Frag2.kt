package br.com.knowledge.capitulo8_fragment.ui.fragment.frag

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import br.com.knowledge.R
import br.com.knowledge.capitulo8_fragment.domain.Hotel
import br.com.knowledge.capitulo8_fragment.ui.fragment.frag.dialog.DialogAlertMsg
import br.com.knowledge.capitulo8_fragment.ui.fragment.frag.dialog.DialogSalveHotel
import br.com.knowledge.capitulo8_fragment.util.FragmentManagerUtil
import br.com.knowledge.capitulo8_fragment.util.LogWrapperUtil
import kotlinx.android.synthetic.main.frag2.*

class Frag2 : Fragment(), Frag1.onHotelListener{

    companion object {

        private const val HOTEL_NAME = "hotel_name"
        const val TAG_NAME = "frag2"
        fun newInstance(name: String) = Frag2().apply {
            arguments = Bundle().apply {
                putString(HOTEL_NAME, name)
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.frag2, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.let{
            tv_frag2.text = it.getString(HOTEL_NAME)
        }

        //dialog com alertDialog
        btn_dialog.setOnClickListener {
            DialogAlertMsg().show(requireActivity().supportFragmentManager, "dialog_msg")
        }

        //dialog com xml customizado
        btn_salve_hotel.setOnClickListener {
            DialogSalveHotel().newInstance().open(requireActivity().supportFragmentManager)
        }

    }

    override fun onClickHotel(hotel: Hotel) {
        LogWrapperUtil.apply {
            info("${hotel.name}")
        }
    }
}