package br.com.knowledge.widge

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import br.com.knowledge.R
import br.com.knowledge.capitulo1.help.fileExtensions.FunExtencionFragment
import br.com.knowledge.capitulo1.help.fileExtensions.newInstance

class WidgeActvity  : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.widge_example)
        supportFragmentManager
            .beginTransaction()
            .add(R.id.content, FunExtencionFragment.newInstance(2)).commit()
    }
}
