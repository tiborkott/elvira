package hu.bme.aut.elvira


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import hu.bme.aut.elvira.adapter.TrainsAdapter
import hu.bme.aut.elvira.data.Trains
import hu.bme.aut.elvira.databinding.ActivityListBinding
import kotlinx.android.synthetic.main.activity_list.*
import java.io.Serializable

class ListActivity : AppCompatActivity() {

    private lateinit var binding: ActivityListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val trains = intent.extras!!.get("trains") as Trains
        var adapter = TrainsAdapter(trains.timetable)

        binding.recyclerViewList.adapter = adapter
        binding.recyclerViewList.setHasFixedSize(true)

        adapter.setOnItemClickListener(object : TrainsAdapter.onItemClickListener{
            override fun onItemClick(position: Int) {
                intent = Intent(this@ListActivity, DetailsActivity::class.java)
                intent.putExtra("url", trains.timetable[position].details[0].train_info.get_url)
                Log.i("INFO", "This is the url" + trains.timetable[position].details[0].train_info.get_url)
                startActivity(intent)
            }

        })

    }

    override fun onBackPressed() {
        super.onBackPressed() // optional depending on your needs
        intent = Intent(this@ListActivity, SearchActivity::class.java)
        startActivity(intent)
        finish()
    }





}