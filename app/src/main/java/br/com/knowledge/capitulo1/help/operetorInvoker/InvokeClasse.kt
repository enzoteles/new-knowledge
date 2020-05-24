package br.com.knowledge.capitulo1.help.operetorInvoker

import android.os.Bundle
import android.text.SpannableStringBuilder
import android.text.style.TextAppearanceSpan
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import br.com.knowledge.R
import br.com.knowledge.capitulo7_mvp.SpannableLink
import br.com.knowledge.capitulo7_mvp.addSpannable


class InvokeActiivity : AppCompatActivity() {

    val callbackStringImpl: (String, Int) -> String = this::callbackString

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.widge_example)

        println(callbackStringImpl.invoke("Agatha", 6))

    }

    //public operator fun plus(other: Any?): String
    fun callbackString(str: String, age:Int): String{
        val union = "$str -- $age"
        Toast.makeText(this, "$union", Toast.LENGTH_LONG).show()
        return union
    }
}