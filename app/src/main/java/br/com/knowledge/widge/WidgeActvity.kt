package br.com.knowledge.widge

import android.graphics.Typeface
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableStringBuilder
import android.text.style.StyleSpan
import android.text.style.TextAppearanceSpan
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import br.com.knowledge.R
import br.com.knowledge.capitulo7_mvp.SpannableLink
import br.com.knowledge.capitulo7_mvp.addSpannable
import kotlinx.android.synthetic.main.fragment_main.*
import kotlinx.android.synthetic.main.widge_example.*

class WidgeActvity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.widge_example)

        //txtStringBuilder.text = configSubtitle()

        val cal = TestLambda("==== enzo"){

        }
        //spannableStr()
        configSubtitle()
    }

    fun spannableStr(){
        val texto = SpannableStringBuilder()
        texto.append("Jeitos de colocar ")
        val start = texto.length
        texto.append("o texto negrito")
        texto.setSpan(
            StyleSpan(Typeface.BOLD), start,
            texto.length, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )
        texto.append(" em um TextView")

        txtStringBuilder.setText(texto)

    }

    fun configSubtitle(){
        val text = SpannableStringBuilder()

        text.append(
            getString(R.string.txt_subtitle_motoboy_step01)
                .addSpannable(
                    TextAppearanceSpan(this, R.style.TextBlue13sp700Normal),
                    SpannableLink { openTerms() })
        )

        text.append(" \n")

        text.append(
            getString(R.string.txt_subtitle_motoboy_step01)
                .addSpannable(
                    TextAppearanceSpan(this, R.style.TextGrayLight13sp700Normal),
                    SpannableLink { openTerms() })
        )

        txtStringBuilder.setText(text)
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
