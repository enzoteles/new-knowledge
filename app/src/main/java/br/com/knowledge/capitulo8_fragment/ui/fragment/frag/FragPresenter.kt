package br.com.knowledge.capitulo8_fragment.ui.fragment.frag

import br.com.knowledge.capitulo8_fragment.domain.Hotel

class FragPresenter(var mView: FragContract.Frag1View){

    fun sendHotel(hotel: Hotel) {
        mView.showHotel(hotel)
    }


}