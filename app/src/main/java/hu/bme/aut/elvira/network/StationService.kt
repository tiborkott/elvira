package hu.bme.aut.elvira.network

import hu.bme.aut.elvira.data.Stations
import hu.bme.aut.elvira.data.Trains
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

//https://apiv2.oroszi.net/elvira/details?url=http%3A%2F%2Felvira.mav-start.hu%2Felvira.dll%2Fx%2Fvt%3Fv%3D930%26d%3D21.11.05%26language%3D1%26ed%3D618413B8

interface StationService {

    @GET("details")
    fun getStations (@Query("url", encoded = true)  url: String) : Call<Stations>
}