package br.com.knowledge.capitulo8_fragment.presenter

import br.com.knowledge.capitulo8_fragment.domain.Hotel
import br.com.knowledge.capitulo8_fragment.ui.Capitulo8Contract

class HotelListPresenter(
    private val mView: Capitulo8Contract.HotelListView,
    private val mRepository:Capitulo8Contract.Repository){

    fun searchHotels(term:String){
        mRepository.search(term){ hotels->
            mView.showHotels(hotels)
        }
    }

    fun showHotelDetail(hotel: Hotel){
        mView.showHotelDetail(hotel)
    }

}