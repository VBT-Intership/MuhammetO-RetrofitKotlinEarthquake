package com.mukireus.earthquakelistkotlin.Core.Model

data class Feature(
    val geometry: Geometry,
    val id: String,
    val properties: Properties,
    val type: String
)