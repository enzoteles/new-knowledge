package br.com.knowledge

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import br.com.knowledge.capitulo3_activity_intent.User
import java.time.LocalDate
import java.time.format.DateTimeFormatter

class MainActivity : AppCompatActivity() {

    @SuppressLint("NewApi")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val string = "2019-06-10"
        Log.i("data", "$string")

        val date = LocalDate.parse(string, DateTimeFormatter.ISO_DATE)

        Log.i("data", "$string -- ${date.dayOfMonth}")


    }
}
