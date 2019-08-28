package br.com.knowledge.capitulo3_activity_intent

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import br.com.knowledge.R
import kotlinx.android.synthetic.main.capitulo3_list.*
import org.parceler.Parcels

class Capitulo3_Lista : AppCompatActivity() {

    lateinit var listUser: ArrayList<User>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.capitulo3_list)

        //técnica para fazer trabalhar com o unwarap do parcelable
        val user = Parcels.unwrap<User>(intent.getParcelableExtra(Capitulo3.USR_NAME))
        //técnica para trabalhar com array list o unwarap do parcelable
        listUser = Parcels.unwrap(intent.getParcelableExtra(Capitulo3.LIST_USER))

        listUser.apply {
            this.forEach{
                Log.i("it", "${it.name}")
            }
        }

        tv_name.text = user.name

    }
}
