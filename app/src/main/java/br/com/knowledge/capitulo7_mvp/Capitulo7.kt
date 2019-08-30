package br.com.knowledge.capitulo7_mvp

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.knowledge.R
import br.com.knowledge.capitulo7_mvp.MainFragment

class Capitulo7 : AppCompatActivity() {

    @SuppressLint("NewApi")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction()
            .add(R.id.content_main, MainFragment(), "man").commit()
    }
}
