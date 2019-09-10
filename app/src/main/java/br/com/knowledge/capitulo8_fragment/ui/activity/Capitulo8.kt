package br.com.knowledge.capitulo8_fragment.ui.activity

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.com.knowledge.R
import br.com.knowledge.capitulo8_fragment.domain.Hotel
import br.com.knowledge.capitulo8_fragment.ui.fragment.Capitulo8Fragment
import br.com.knowledge.capitulo8_fragment.ui.fragment.HotelListFragment
import br.com.knowledge.capitulo8_fragment.ui.fragment.frag.Frag1
import br.com.knowledge.capitulo8_fragment.util.FragmentManagerUtil
import br.com.knowledge.capitulo8_fragment.util.LogWrapperUtil


open class Capitulo8 : AppCompatActivity(), HotelListFragment.OnHotelClickListener {

    @SuppressLint("NewApi")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.capitulo8)
        //log
        LogWrapperUtil.run {
            info("onCreate")
        }

        /*FragmentManagerUtil.apply {
            addFragment(
                R.id.content_capitulo8,
                HotelListFragment(),
                "capitulo8",
                false,
                supportFragmentManager
            )
        }*/

        FragmentManagerUtil.apply {
            addFragment(
                R.id.content_capitulo8,
                Frag1(),
                "frag1",
                false,
                supportFragmentManager
            )
        }
    }

    override fun onResume() {
        super.onResume()
        LogWrapperUtil.run {
            info("onResumo")
        }
    }

    override fun onStart() {
        super.onStart()
        LogWrapperUtil.run {
            info("onStart")
        }
    }

    override fun onRestart() {
        super.onRestart()
        LogWrapperUtil.run {
            info("onRestart")
        }
    }

    override fun onStop() {
        super.onStop()
        LogWrapperUtil.run {
            info("onStop")
        }
    }

    override fun onPause() {
        super.onPause()
        LogWrapperUtil.run {
            info("onPause")
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        LogWrapperUtil.run {
            info("onDestroy")
        }
    }

    override fun onHotelClick(hotel: Hotel) {
        showDetailActivity(hotel.id)
    }

    private fun showDetailActivity(id: Long) {
        HotelDetailActivity.open(this, id)
    }


}