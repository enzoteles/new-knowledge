package br.com.knowledge.capitulo8_fragment.ui.fragment.frag

import br.com.knowledge.capitulo8_fragment.domain.Hotel

interface FragContract{

    interface Frag1View{
        fun showHotel(hotel:Hotel)
    }
    interface Frag2View
}