package br.com.knowledge.widge

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.core.content.ContextCompat
import br.com.knowledge.R
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import kotlinx.android.synthetic.main.custom_view_bottom_sheet_generic.*

/**
 * @author Enzo Teles
 * 08/05/2020
 * componente atualizado
 * */
class BottomSheetGenericFragment(var nameToolbar: String, var drawable: Int, var title:String, var subtitle: String, var statusBtnClose:Boolean, var statusBtnOk:Boolean) : BottomSheetDialogFragment(){


    companion object {
        fun newInstance(
            nameToolbar: String,
            image: Int,
            title: String,
            subtitle: String,
            statusBtnClose: Boolean,
            statusBtnOk: Boolean
        ): BottomSheetGenericFragment {
            return BottomSheetGenericFragment(nameToolbar, image, title, subtitle, statusBtnClose, statusBtnOk)
        }
    }


    var onClick: OnClickButtonsOptionsListener? = null

    interface OnClickButtonsOptionsListener {
        fun onBtnClose(dialog: Dialog)
        fun onBtnOk(dialog: Dialog)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val view = inflater.inflate(R.layout.bottom_sheet_generic_layout, container, false)
        return view
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        val dialog = super.onCreateDialog(savedInstanceState)

        dialog.setOnShowListener {
            // For AndroidX use: com.google.android.material.R.id.design_bottom_sheet
            val bottomSheet = dialog.findViewById<View>(
                    com.google.android.material.R.id.design_bottom_sheet) as? FrameLayout
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

        btn_close.visibility = if(statusBtnClose) View.VISIBLE else View.INVISIBLE
        retryButton.visibility = if(statusBtnOk) View.VISIBLE else View.INVISIBLE

        view.viewTreeObserver.addOnGlobalLayoutListener {
            val dialog = dialog as BottomSheetDialog
            val bottomSheet = dialog.findViewById<View>(com.google.android.material.R.id.design_bottom_sheet) as FrameLayout?
            val behavior = BottomSheetBehavior.from(bottomSheet!!)
            behavior.state = BottomSheetBehavior.STATE_EXPANDED
            behavior.peekHeight = 0
        }

        btn_close.setOnClickListener {
            //dismiss()
            dialog?.let { it1 -> onClick?.onBtnClose(it1) }
        }

       /* retryButton.setText(getString(R.string.text_close_capitalized_label))
        retryButton.setOnClickListener {
            //dismiss()
            dialog?.let { it1 -> onClick?.onBtnOk(it1) }
        }

        txt_title.text = title
        txt_subtitle.text = subtitle
        txt_toobar_name.text = nameToolbar
        img_bottom_sheet.background = ContextCompat.getDrawable(requireContext(), drawable)*/
    }


}