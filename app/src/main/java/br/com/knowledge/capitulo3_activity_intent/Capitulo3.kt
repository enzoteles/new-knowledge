package br.com.knowledge.capitulo3_activity_intent

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import br.com.knowledge.R
import kotlinx.android.synthetic.main.capitulo3.*
import org.parceler.Parcels

class Capitulo3 : AppCompatActivity() {

    var listaUser:ArrayList<User> = ArrayList()

    companion object{
        const val USR_NAME = "user"
        const val LIST_USER = "list_user"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.capitulo3)

        //add user na lista e passar por parametro
        val s1 = User("agatha", 8)
        val s2 = User("sophia", 5)
        val s3 = User("julia", 2)
        listaUser.add(s1)
        listaUser.add(s2)
        listaUser.add(s3)

        val s = 1.215752191E7.toPtBrRealString()

        val value = String.format(getString(R.string.tv_name), s)

        tv_name.run {
            text = value
        }

        //técnica para fazer trabalhar com parcelable no objeto
        btn_ok.setOnClickListener {
            val user = User("enzo", 27)
            val intent = Intent(this, Capitulo3_Lista::class.java)
            intent.putExtra(USR_NAME, Parcels.wrap(user))
            intent.putExtra(LIST_USER, Parcels.wrap(listaUser))
            startActivity(intent)
        }

    }
}
