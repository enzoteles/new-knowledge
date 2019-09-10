package br.com.knowledge.capitulo8_fragment.ui

import br.com.knowledge.capitulo8_fragment.domain.Hotel

interface Capitulo8Contract{

    interface HotelListView{
        fun showHotels(hotels: List<Hotel>)
        fun showHotelDetail(hotel: Hotel)

    }

    interface Repository{

        fun saveHotel(hotel: Hotel)
        fun removeHotel(vararg hotels: Hotel)
        fun hotelById(id:Long, callback: (Hotel?) -> Unit)
        fun search(term:String, callback:(List<Hotel>)->Unit)

    }

    interface HotelDetailView{
        fun showHotelDetails(hotel: Hotel)
        fun errorHotelNotFound()
    }

}