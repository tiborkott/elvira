package hu.bme.aut.elvira

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import hu.bme.aut.elvira.databinding.ActivityLoadBinding

class LoadActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoadBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoadBinding.inflate(layoutInflater)
        setContentView(binding.root)


        startActivity(Intent(this@LoadActivity, SearchActivity::class.java))
        finish()
    }
}