package hu.bme.aut.elvira

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import hu.bme.aut.elvira.databinding.ActivitySearchBinding


class SearchActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySearchBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.Theme_Elvira)
        supportActionBar?.show()
        binding = ActivitySearchBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

    }
}