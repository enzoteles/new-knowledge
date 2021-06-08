package br.com.myapp

import android.app.Dialog
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import br.com.knowledge.R
import br.com.knowledge.generics.BackCustom
import br.com.knowledge.generics.Bank
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import kotlinx.android.synthetic.main.layout_item_bank.view.*
import kotlinx.android.synthetic.main.layout_radio_bt.*

class RadioButtomBT(val listBank: List<BackCustom<Bank>>) : BottomSheetDialogFragment() {


    companion object {
        fun newInstance(listBank: List<BackCustom<Bank>>): RadioButtomBT {
            return RadioButtomBT(listBank)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view =
            inflater.inflate(R.layout.layout_radio_bt, container, false)
        return view
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        val dialog = super.onCreateDialog(savedInstanceState)

        dialog.setOnShowListener {
            // For AndroidX use: com.google.android.material.R.id.design_bottom_sheet
            val bottomSheet = dialog.findViewById<View>(
                com.google.android.material.R.id.design_bottom_sheet
            )
            val behavior = BottomSheetBehavior.from(bottomSheet)
            behavior.state = BottomSheetBehavior.STATE_EXPANDED
            behavior.peekHeight = 0
            behavior.setBottomSheetCallback(object : BottomSheetBehavior.BottomSheetCallback() {
                override fun onStateChanged(bottomSheet: View, newState: Int) {
                    // React to state change
                    if (newState >= 4) {
                        dismiss()
                    }
                }

                override fun onSlide(bottomSheet: View, slideOffset: Float) {
                    // React to dragging events
                }
            })
        }

        return dialog
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        showContentBanks()
    }

    private fun showContentBanks() {
        this.ll_banks.removeAllViews()
        this.listBank.forEach { itModel->
            LayoutInflater.from(requireContext()).inflate(R.layout.layout_item_bank, null, false)?.let {
                this.ll_banks.addView(it)
                it.tvNomeBanco.text = itModel.nomeBancoCustom
                it.tvAgencia.text = itModel.agenciaCustom
                it.tvNumeroConta.text = itModel.contaCustom
                it.setOnClickListener { itViews->
                    for(idx in 0 until  this.ll_banks.childCount){
                        this.ll_banks.getChildAt(idx).let { itChildView->
                            itChildView.findViewById<RadioButton>(R.id.radioButton).let { itRadioButton->
                                itRadioButton.isChecked = false
                            }
                        }
                    }
                    itViews.findViewById<RadioButton>(R.id.radioButton).let { itRadioButton->
                        itRadioButton.isChecked = true
                        setBank(itModel)
                    }
                }
            }
        }
    }

    private fun setBank(itModel: BackCustom<Bank>) {
        Log.i("BANK", "${itModel.data}")
    }

}