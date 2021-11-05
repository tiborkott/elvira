package hu.bme.aut.elvira.network


import hu.bme.aut.elvira.data.Trains
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

//API
//https://apiv2.oroszi.net/elvira?from=Budapest&to=Gy%C5%91r&date=2021.11.03

interface TrainService {
    @GET("/elvira")
    fun getTrains (@Query("from")  from: String,
                   @Query("to")  to: String,
                   @Query("date")  date: String,
                   @Query ("fromtime") fromtime: String
    ) : Call<Trains>
}