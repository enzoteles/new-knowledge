package br.com.knowledge.capitulo8_fragment.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import br.com.knowledge.R
import br.com.knowledge.capitulo8_fragment.domain.Hotel
import br.com.knowledge.capitulo8_fragment.presenter.HotelDetailPresenter
import br.com.knowledge.capitulo8_fragment.ui.Capitulo8Contract
import br.com.knowledge.capitulo8_fragment.util.MemoryRepository
import kotlinx.android.synthetic.main.capitulo8_hotel_details.*

class HotelDetailFragment : Fragment(), Capitulo8Contract.HotelDetailView{

    private val presenter = HotelDetailPresenter(this, MemoryRepository)

    companion object{
        const val TAG_DETAILS = "tagDetail"
        private const val EXTRA_HOTEL_ID = "hotelid"

        fun newInstance(id: Long) = HotelDetailFragment()
            .apply {
                arguments = Bundle()
                    .apply {
                        putLong(EXTRA_HOTEL_ID, id)
                    }
            }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.capitulo8_hotel_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.loadHotelDetails(arguments?.getLong(EXTRA_HOTEL_ID, -1) ?: -1)
    }

    override fun showHotelDetails(hotel: Hotel) {
        tv_ht_name.text = hotel.name
        tv_ht_address.text = hotel.address
        ratingBar.rating = hotel.rating
    }

    override fun errorHotelNotFound() {
        tv_ht_name.text = "Hotel Not Found"
        tv_ht_address.visibility = View.GONE
        ratingBar.visibility = View.GONE
    }


}