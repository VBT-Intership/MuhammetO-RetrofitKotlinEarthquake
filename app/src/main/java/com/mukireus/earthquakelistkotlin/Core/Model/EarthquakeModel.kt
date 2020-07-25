package com.mukireus.earthquakelistkotlin.Core.Model

import com.google.gson.annotations.SerializedName

data class EarthquakeModel(
    @SerializedName("place")
    var place: String,
    @SerializedName("magnitude")
    var magnitude: Double,
    @SerializedName("time")
    var time: Long,
    @SerializedName("detailLink")
    var detailLink: String,
    @SerializedName("type")
    var type: String,
    @SerializedName("lat")
    var lat: Double,
    @SerializedName("lon")
    var lon: Double
)