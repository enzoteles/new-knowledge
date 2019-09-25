package br.com.knowledge.capitulo2_laoyout

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.viewpager.widget.ViewPager
import br.com.knowledge.R
import br.com.knowledge.capitulo8_fragment.util.FragmentManagerUtil
import br.com.knowledge.capitulo8_fragment.util.LogWrapperUtil
import com.google.android.material.tabs.TabLayout


class Capitulo2_TabLayout : AppCompatActivity() {

    var tabLayout: TabLayout?= null
    var viewPager: ViewPager?= null
    var viewPagerAdapter: ViewPagerAdapter ?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.capitulo2_tablayout)
        val toolbar = findViewById(R.id.toolbar) as Toolbar

        viewPager = findViewById(R.id.viewPager) as ViewPager
        viewPagerAdapter = ViewPagerAdapter(supportFragmentManager)
        viewPager!!.adapter = viewPagerAdapter
        tabLayout?.setupWithViewPager(viewPager)

        tabLayout?.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                LogWrapperUtil.info("onTabSelected ==> ${tab}")
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
                LogWrapperUtil.info("onTabUnselected ==> ${tab}")
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
                LogWrapperUtil.info("onTabReselected ====> ${tab}")
            }
        })
    }
}
