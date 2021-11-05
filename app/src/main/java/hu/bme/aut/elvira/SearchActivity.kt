package hu.bme.aut.elvira

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import hu.bme.aut.elvira.data.Trains
import hu.bme.aut.elvira.databinding.ActivitySearchBinding
import hu.bme.aut.elvira.network.TrainService
import hu.bme.aut.elvira.network.HTTPLogger
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.Serializable
import java.text.SimpleDateFormat
import java.util.*

class SearchActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySearchBinding

    //setTheme(R.style.Theme_Elvira)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySearchBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val btnSearch = binding.btnSearch
        btnSearch.setOnClickListener {
            onSearch()
        }
    }

    @SuppressLint("SimpleDateFormat")
    private fun  onSearch(){

        val retrofit = Retrofit.Builder()
            .baseUrl("https://apiv2.oroszi.net")
            .addConverterFactory(GsonConverterFactory.create())
            .client(HTTPLogger.getLogger())
            .build()

        val service = retrofit.create(TrainService::class.java)

        val currentDate: Date = Calendar.getInstance().time
        val simpledateformat = SimpleDateFormat("yyyy.MM.dd")
        val simpletimeformat = SimpleDateFormat("HH:mm")
        val currentFormatedDate = simpledateformat.format(currentDate)
        val currentFormtedTime = simpletimeformat.format(currentDate)
        val call = service.getTrains(binding.actvFrom.text.toString(),binding.actvTo.text.toString(), currentFormatedDate.toString(), currentFormtedTime.toString())


        call.enqueue(object : Callback<Trains> {
            override fun onResponse(call: Call<Trains>, response: Response<Trains>) {
                if (response.isSuccessful){
                    Log.d("DEBUG", "GET SUCCESS RESPONSE GOOD")
                    intent = Intent(this@SearchActivity, ListActivity::class.java)
                    intent.putExtra("trains", response.body() as Serializable)
                    startActivity(intent)
                    finish()
                }
            }

            override fun onFailure(call: Call<Trains>, t: Throwable) {
                Toast.makeText(this@SearchActivity,"Internet connection failure",Toast.LENGTH_SHORT).show()
                Log.d("DEBUG", "GET FAIL")
            }
        })
    }
}
