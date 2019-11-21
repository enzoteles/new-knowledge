package br.com.knowledge.capitulo7_mvp

import android.text.style.ClickableSpan
import android.view.View
import android.text.TextPaint


class SpannableLink(private val clickFunc: () -> Unit) : ClickableSpan() {
    override fun onClick(p0: View) {
        clickFunc()
    }

    override fun updateDrawState(ds: TextPaint) {
        ds.isUnderlineText = true
    }
}