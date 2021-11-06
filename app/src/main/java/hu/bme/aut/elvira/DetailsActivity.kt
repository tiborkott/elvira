package hu.bme.aut.elvira

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import hu.bme.aut.elvira.adapter.StationsAdapter
import hu.bme.aut.elvira.data.Stations
import hu.bme.aut.elvira.databinding.ActivityDetailsBinding
import hu.bme.aut.elvira.network.HTTPLogger
import hu.bme.aut.elvira.network.StationService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class DetailsActivity: AppCompatActivity() {

    private lateinit var binding: ActivityDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //"https://apiv2.oroszi.net/elvira/details?url=http%3A%2F%2Felvira.mav-start.hu%2Felvira.dll%2Fx%2Fvt%3Fv%3D930%26d%3D21.11.05%26language%3D1%26ed%3D618413B8"
        val url =  intent.extras!!.get("url").toString()

        val retrofit = Retrofit.Builder()
            .baseUrl("https://apiv2.oroszi.net/elvira/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(HTTPLogger.getLogger())
            .build()

        val service = retrofit.create(StationService::class.java)
        val geturl = url.substringAfter("=")
        val call = service.getStations(geturl)
        var adapter : StationsAdapter?

        call.enqueue(object : Callback<Stations> {
            override fun onResponse(call: Call<Stations>, response: Response<Stations>) {
                if (response.isSuccessful){
                    Log.d("DEBUG", "GET SUCCESS RESPONSE GOOD")
                    adapter = response.body()?.let { StationsAdapter(it) }
                    binding.recyclerViewDetails.adapter = adapter
                    binding.recyclerViewDetails.setHasFixedSize(true)
                }
            }

            override fun onFailure(call: Call<Stations>, t: Throwable) {
                Toast.makeText(this@DetailsActivity,"Internet connection failure", Toast.LENGTH_SHORT).show()
                Log.d("DEBUG", "GET FAIL")
            }
        })


    }
}