
import android.text.SpannableStringBuilder
import android.text.Spanned
import android.text.style.TextAppearanceSpan
import br.com.knowledge.capitulo7_mvp.SpannableLink


fun CharSequence.addSpannable(font: TextAppearanceSpan): SpannableStringBuilder {
    val ssb = SpannableStringBuilder()
    ssb.append(this)
    ssb.setSpan(font, 0, this.length, Spanned.SPAN_COMPOSING)
    return ssb
}


fun  CharSequence.addSpannable(font: TextAppearanceSpan, clickableSpan: SpannableLink): SpannableStringBuilder {
    val ssb = SpannableStringBuilder()
    ssb.append(this)
    ssb.setSpan(clickableSpan, 0, this.length, Spanned.SPAN_COMPOSING)
    ssb.setSpan(font, 0, this.length, Spanned.SPAN_COMPOSING)
    return ssb
}

