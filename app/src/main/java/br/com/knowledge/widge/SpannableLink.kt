package br.com.mobicare.cielo.commons.utils.spannable

import android.text.TextPaint
import android.text.style.ClickableSpan
import android.view.View


class SpannableLink(private val clickFunc: () -> Unit) : ClickableSpan() {

    override fun updateDrawState(ds: TextPaint) {
        ds.isUnderlineText = true
    }

    override fun onClick(widget: View) {
        clickFunc()
    }


}