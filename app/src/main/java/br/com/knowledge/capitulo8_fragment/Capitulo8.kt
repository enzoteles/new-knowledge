package br.com.knowledge.capitulo8_fragment

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.com.knowledge.R
import kotlinx.android.synthetic.main.capitulo8_frag.*


open class Capitulo8 : AppCompatActivity() {

    @SuppressLint("NewApi")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.capitulo8)
        //log
        LogWrapperUtil.run {
            info("onCreate")
        }

        FragmentManagerUtil.apply {
            addFragment(R.id.content_capitulo8, Capitulo8Fragment(), "capitulo8",false, supportFragmentManager)
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

}