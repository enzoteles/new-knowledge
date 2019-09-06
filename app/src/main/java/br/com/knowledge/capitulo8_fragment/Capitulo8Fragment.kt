package br.com.knowledge.capitulo8_fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import br.com.knowledge.R
import kotlinx.android.synthetic.main.capitulo8_frag.*


class Capitulo8Fragment : Fragment() {


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

        val view = inflater.inflate(R.layout.capitulo8_frag, container, false)
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
        btn_cap8.setOnClickListener {
            FragmentManagerUtil.apply {
                replaceFragment(R.id.content_capitulo8, Capitulo8Fragment2(), "capitulo8_frag2", true, requireActivity().supportFragmentManager)
            }
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
            info("onStop.Frag")
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