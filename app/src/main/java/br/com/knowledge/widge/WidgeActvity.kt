package br.com.knowledge.widge

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import br.com.knowledge.R

class WidgeActvity  : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.widge_example)

        ManagerFragment(this)
            .tag("TesteFragment")
            .backstack(true)
            .layout(R.id.rootLayout)
            .addFragment(TesteFragment())
            .build()

    }
}

class TesteFragment: Fragment()