package br.com.knowledge.widge

import android.os.Bundle
import android.provider.Settings
import android.text.SpannableStringBuilder
import android.text.style.TextAppearanceSpan
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import br.com.knowledge.R
import br.com.knowledge.capitulo1.help.fileExtensions.FunExtencionFragment
import br.com.knowledge.capitulo1.help.fileExtensions.newInstance
import br.com.knowledge.capitulo7_mvp.SpannableLink
import br.com.knowledge.capitulo7_mvp.addSpannable
import kotlinx.android.synthetic.main.widge_example.*

class WidgeActvity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.widge_example)

        //txtStringBuilder.setText(configSubtitle(), TextView.BufferType.SPANNABLE)
        val cal = TestLambda("==== enzo"){

        }
    }

    fun configSubtitle(): SpannableStringBuilder {
        val text = SpannableStringBuilder()

        text.append(
            getString(R.string.txt_subtitle_motoboy_step01))
            .addSpannable(
                TextAppearanceSpan(this, R.style.TextBlue13sp700Normal),SpannableLink { openTerms() }
        )
        text.append(" \n")

        text.append(
            getString(R.string.txt_subtitle_motoboy_step01)
                .addSpannable(
                    TextAppearanceSpan(this, R.style.TextGrayLight13sp700Normal),
                    SpannableLink { openTerms() })
        )

        return text
    }

    private fun openTerms() {
        Toast.makeText(this, "open", Toast.LENGTH_LONG).show()
    }

}

class TestLambda(name: String, var callback:(String)->Unit){

    var name:String?= null

    init {
        this.name = name
        callback.invoke(this.name!!)

    }

}
