package br.com.knowledge.capitulo8_fragment.ui.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import br.com.knowledge.R
import br.com.knowledge.capitulo8_fragment.util.LogWrapperUtil


class Capitulo8Fragment2 : Fragment() {


    override fun onAttach(context: Context?) {
        super.onAttach(context)
        LogWrapperUtil.apply {
            info("onAttach")
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        LogWrapperUtil.apply {
            info("onCreate.Frag")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.capitulo8_frag2, container, false)
        LogWrapperUtil.apply {
            info("onCreateView")
        }
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        LogWrapperUtil.apply {
            info("onActvityCreated")
        }
    }

    override fun onStart() {
        super.onStart()
        LogWrapperUtil.apply {
            info("onStart.Frag")
        }
    }

    override fun onResume() {
        super.onResume()
        LogWrapperUtil.apply {
            info("onResume.Frag")
        }
    }

    override fun onPause() {
        super.onPause()
        LogWrapperUtil.apply {
            info("onPause.Frag")
        }
    }

    override fun onStop() {
        super.onStop()
        LogWrapperUtil.apply {
            info("onStop")
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        LogWrapperUtil.apply {
            info("onDestroyView")
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        LogWrapperUtil.apply {
            info("onDestroy.Frag")
        }
    }

    override fun onDetach() {
        super.onDetach()
        LogWrapperUtil.apply {
            info("onDetach")
        }

    }

}