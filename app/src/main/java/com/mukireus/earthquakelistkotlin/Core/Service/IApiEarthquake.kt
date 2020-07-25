package com.mukireus.earthquakelistkotlin.Core.Service

import com.mukireus.earthquakelistkotlin.Core.Model.EarthquakeModel
import retrofit2.Call
import retrofit2.http.GET

interface IApiEarthquake {
    @GET("/all_day.geojson")
    fun getHttpEarthquakeList(): Call<List<EarthquakeModel>>
}
