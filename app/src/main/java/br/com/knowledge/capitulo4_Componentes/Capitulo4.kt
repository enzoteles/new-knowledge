package br.com.knowledge.capitulo4_Componentes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.LinkMovementMethod
import android.text.util.Linkify
import android.util.Patterns
import br.com.knowledge.R
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
