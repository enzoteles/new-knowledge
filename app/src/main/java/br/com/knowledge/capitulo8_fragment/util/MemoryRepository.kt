package br.com.knowledge.capitulo8_fragment.util

import android.annotation.SuppressLint
import br.com.knowledge.capitulo8_fragment.domain.Hotel
import br.com.knowledge.capitulo8_fragment.ui.Capitulo8Contract

object MemoryRepository : Capitulo8Contract.Repository {

    private var nextId = 1L
    private val hotelsList = mutableListOf<Hotel>()

    init {
        saveHotel(Hotel(0, "New Beach", "Av. Boa Viagem", 4.5f))
        saveHotel(Hotel(0, "New Usa", "Av. Boa Sorte", 4.5f))
        saveHotel(Hotel(0, "Old Beach", "Av. Tra Viagem", 4.5f))
    }

    override fun saveHotel(hotel: Hotel) {
        if (hotel.id == 0L) {
            hotel.id = nextId++
            hotelsList.add(hotel)
        } else {
            val index = hotelsList.indexOfFirst {
                it.id == hotel.id
            }
            if (index > -1) {
                hotelsList[index] = hotel
            } else {
                hotelsList.add(hotel)
            }
        }
    }

    @SuppressLint("NewApi")
    override fun removeHotel(vararg hotels: Hotel) {
        hotelsList.removeAll(hotels)
    }

    override fun hotelById(id: Long, callback: (Hotel?) -> Unit) {
        callback(
            hotelsList?.find {
                it.id == id
            }
        )
    }

    override fun search(term: String, callback: (List<Hotel>) -> Unit) {
        callback(
            if (term.isEmpty()) hotelsList
            else hotelsList.filter {
                it.name.toUpperCase().contains(term.toUpperCase())
            }
        )
    }

}