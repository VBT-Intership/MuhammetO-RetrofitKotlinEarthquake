package com.mukireus.earthquakelistkotlin.Core.Service

import com.google.gson.GsonBuilder
import com.mukireus.earthquakelistkotlin.Core.AppConstants
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {
    val getClient: IApiEarthquake
        get() {
            val gson = GsonBuilder().setLenient().create()
            val client = OkHttpClient.Builder().build()
            val retrofit = Retrofit.Builder().baseUrl(AppConstants.API_URL).client(client)
                .addConverterFactory(GsonConverterFactory.create(gson)).build()
            return retrofit.create(IApiEarthquake::class.java)
        }
}