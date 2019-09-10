package br.com.knowledge.capitulo8_fragment.presenter

import br.com.knowledge.capitulo8_fragment.ui.Capitulo8Contract

class HotelDetailPresenter(
    var mView: Capitulo8Contract.HotelDetailView,
    var mRepository: Capitulo8Contract.Repository
) {

    fun loadHotelDetails(id: Long) {
        mRepository.hotelById(id) { hotel ->
            hotel?.apply { mView.showHotelDetails(this) }?:run { mView.errorHotelNotFound() }
        }
    }

}