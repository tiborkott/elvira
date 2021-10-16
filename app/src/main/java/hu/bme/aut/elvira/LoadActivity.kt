package hu.bme.aut.elvira

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class LoadActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.Theme_Elvira)
        supportActionBar?.hide()

        startActivity(Intent(this@LoadActivity, SearchActivity::class.java))
        finish()


    }
}