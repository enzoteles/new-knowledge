package br.com.knowledge.capitulo8_fragment.ui.fragment

import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.fragment.app.Fragment
import androidx.fragment.app.ListFragment
import br.com.knowledge.capitulo8_fragment.domain.Hotel
import br.com.knowledge.capitulo8_fragment.presenter.HotelListPresenter
import br.com.knowledge.capitulo8_fragment.ui.Capitulo8Contract
import br.com.knowledge.capitulo8_fragment.util.MemoryRepository

class HotelListFragment: ListFragment(), Capitulo8Contract.HotelListView{
    //init presenter
    private val presenter = HotelListPresenter(this, MemoryRepository)

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        presenter.searchHotels("")
    }

    override fun showHotels(hotels: List<Hotel>) {
        val adapter =  ArrayAdapter<Hotel>(requireContext(), android.R.layout.simple_list_item_1, hotels)
        listAdapter = adapter

    }

    override fun showHotelDetail(hotel: Hotel) {
        //será implementado em breve
        if(activity is OnHotelClickListener){
            val listener = activity as OnHotelClickListener
            listener.onHotelClick(hotel)
        }
    }

    override fun onListItemClick(l: ListView?, v: View?, position: Int, id: Long) {
        super.onListItemClick(l, v, position, id)
        val hotel = l?.getItemAtPosition(position) as Hotel
        presenter.showHotelDetail(hotel)
    }

    interface OnHotelClickListener{
        fun onHotelClick(hotel :Hotel)
    }

}