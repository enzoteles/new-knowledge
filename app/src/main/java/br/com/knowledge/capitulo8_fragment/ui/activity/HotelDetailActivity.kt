package br.com.knowledge.capitulo8_fragment.ui.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.com.knowledge.R
import br.com.knowledge.capitulo8_fragment.ui.fragment.HotelDetailFragment
import br.com.knowledge.capitulo8_fragment.util.FragmentManagerUtil

class HotelDetailActivity : AppCompatActivity(){

    companion object{
        private const val EXTRA_HOTEL_ID = "hotel_id"
        fun open(context: Context, hotelid: Long){
            context.startActivity(Intent(context, HotelDetailActivity::class.java)
                .apply {
                    putExtra(EXTRA_HOTEL_ID, hotelid)
                })
        }
    }

    private val hotelId: Long by lazy {
        intent.getLongExtra(EXTRA_HOTEL_ID, -1)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hotel_detail)
        if(savedInstanceState == null){
            showHotelDetailsFragment()
        }
    }

    private fun showHotelDetailsFragment() {
        val fragment = HotelDetailFragment.newInstance(hotelId)
        FragmentManagerUtil.apply {
            replaceFragment(R.id.details, fragment, HotelDetailFragment.TAG_DETAILS, false, supportFragmentManager)
        }
    }

}