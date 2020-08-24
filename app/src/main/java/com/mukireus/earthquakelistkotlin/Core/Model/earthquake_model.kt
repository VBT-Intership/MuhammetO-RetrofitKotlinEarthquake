package com.mukireus.earthquakelistkotlin.Core.Model

data class EarthquakeModel(
    val bbox: List<Double>,
    val features: List<Feature>,
    val metadata: Metadata,
    val type: String
)