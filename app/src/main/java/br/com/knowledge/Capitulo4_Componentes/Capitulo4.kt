package br.com.knowledge.Capitulo4_Componentes

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.LinkMovementMethod
import android.text.util.Linkify
import android.util.Log
import android.util.Patterns
import androidx.core.content.ContextCompat
import br.com.knowledge.R
import br.com.knowledge.capitulo3_activity_intent.User
import kotlinx.android.synthetic.main.capitulo4.*

class Capitulo4 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.capitulo4)

        //atributo de link de telefone
        if(phone != null){
            Linkify.addLinks(phone, Patterns.PHONE,"tel:",Linkify.sPhoneNumberMatchFilter,Linkify.sPhoneNumberTransformFilter)
            phone.setMovementMethod(LinkMovementMethod.getInstance())
            phone.setTextColor(resources.getColor(R.color.blue))
        }
    }
}
