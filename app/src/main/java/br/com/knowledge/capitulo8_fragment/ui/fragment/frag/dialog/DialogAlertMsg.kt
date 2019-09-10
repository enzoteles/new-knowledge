package br.com.knowledge.capitulo8_fragment.ui.fragment.frag.dialog

import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.DialogFragment


class DialogAlertMsg : DialogFragment(){

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val listener = DialogInterface.OnClickListener { _, i ->

            if( i== DialogInterface.BUTTON_NEGATIVE){
                val intent = Intent(Intent.ACTION_VIEW,
                    Uri.parse("http://www.javafree.org/artigo/871446/Apresentando-ModelViewPresenter-o-MVC-focado-na-visualizacao.html"))
                startActivity(intent)
            }
        }

        return AlertDialog.Builder(requireContext())
            .setTitle("Dialog Fragment")
            .setMessage("criando alert com dialog")
            .setPositiveButton("ok", null)
            .setNegativeButton("não", listener)
            .create()

    }

}
