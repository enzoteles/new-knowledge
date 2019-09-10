package br.com.knowledge.capitulo8_fragment.ui.fragment.frag.dialog

import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.FragmentManager
import br.com.knowledge.R
import br.com.knowledge.capitulo8_fragment.util.LogWrapperUtil
import kotlinx.android.synthetic.main.capitulo8.view.*
import kotlinx.android.synthetic.main.dialog_salve_hotel.*


class DialogSalveHotel : DialogFragment(){

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.dialog_salve_hotel, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dialog.setTitle("SALVANDO HOTEL")
        dialog?.window?.setSoftInputMode(
            WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE
        )
        tv_01.setOnClickListener {
            LogWrapperUtil.apply {
                info("button01")
            }
        }

    }

    fun open(fm: FragmentManager) {
        if (fm.findFragmentByTag("dialog_save") == null) {
            show(fm, "dialog_save")
        }
    }

    fun newInstance() = DialogSalveHotel()

}
