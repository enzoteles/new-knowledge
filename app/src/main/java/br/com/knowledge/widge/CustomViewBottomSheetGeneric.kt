package br.com.knowledge.widge

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
import br.com.knowledge.R
import kotlinx.android.synthetic.main.custom_view_bottom_sheet_generic.view.*

class CustomViewBottomSheetGeneric @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) :
    ConstraintLayout(context, attrs, defStyleAttr) {


    init {
        LayoutInflater.from(context).inflate(R.layout.custom_view_bottom_sheet_generic, this, true)

        attrs?.let {
            val typeArray = context.obtainStyledAttributes(
                it,
                R.styleable.bottom_sheet_generic_attributes,
                0,
                0
            )

            val toolbarName = resources.getText(
                typeArray.getResourceId(
                    R.styleable.bottom_sheet_generic_attributes_bs_toolbar_name,
                    R.string.txt_aguardando_motoboy
                )
            )
            val title = resources.getText(
                typeArray.getResourceId(
                    R.styleable.bottom_sheet_generic_attributes_bs_title,
                    R.string.txt_title_motoboy
                )
            )
            val subtitle = resources.getText(
                typeArray.getResourceId(
                    R.styleable.bottom_sheet_generic_attributes_bs_subtitle,
                    R.string.txt_subtitle_motoboy
                )
            )
            val btnName = resources.getText(
                typeArray.getResourceId(
                    R.styleable.bottom_sheet_generic_attributes_bs_btn_name,
                    R.string.ok
                )
            )

            val btnCloseStatus = typeArray.getBoolean(
                R.styleable.bottom_sheet_generic_attributes_bs_btn_close_status,
                true
            )

            val btnOkStatus = typeArray.getBoolean(
                R.styleable.bottom_sheet_generic_attributes_bs_btn_ok_status,
                true

            )

            val img = typeArray.getDrawable(R.styleable.bottom_sheet_generic_attributes_bs_image)

           /* txt_toobar_name.text = toolbarName
            txt_title.text = title
            txt_subtitle.text = subtitle
            retryButton.setText(btnName.toString())*/

            img_bottom_sheet.background = img

            btn_close.visibility = if (btnCloseStatus) View.VISIBLE else View.INVISIBLE
            retryButton.visibility = if (btnOkStatus) View.VISIBLE else View.INVISIBLE

            typeArray.recycle()
        }

    }


}