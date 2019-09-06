package br.com.knowledge.capitulo6_component2

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.LinearLayout
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSnapHelper
import androidx.recyclerview.widget.RecyclerView
import br.com.knowledge.R
import br.com.knowledge.capitulo7_mvp.MainFragment
import kotlinx.android.synthetic.main.capitulo6.*

class Capitulo6 : AppCompatActivity() {

    var listMSG  = ArrayList<Message>()
    var adadpter = MessagesAdapter(listMSG, this::showMessage)
    val validation :String ?= ""

    @SuppressLint("NewApi")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.capitulo6)

        validation.takeUnless {
            it.isNullOrEmpty()
        }?.let {
            Log.i("takeif", "error")
        }

        btn_insert.setOnClickListener {

           /* et_msg?.let {
                updateView()
            } ?: run {
                Toast.makeText(this, "campo vazio", Toast.LENGTH_LONG).show()
            }*/
            rv_msg.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
            rv_msg.adapter = adadpter
        }

    }

    private fun updateView() {

        val msg = Message(et_msg.text.toString())
        listMSG.add(msg)
        adadpter.notifyItemInserted(listMSG.lastIndex)

    }

    fun showMessage(msg: Message) {
        Toast.makeText(this, "${msg.msg}", Toast.LENGTH_LONG).show()
    }
}
