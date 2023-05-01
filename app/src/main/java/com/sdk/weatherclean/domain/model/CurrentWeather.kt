package com.sdk.weatherclean.domain.model

data class CurrentWeather(
    val long: Double,
    val lat: Double,
    val title: String,
    val description: String,
    val icon: String,
    val temp: Double,
    val pressure: Int,
    val humidity: Int,
    val name: String,
    val timeZone: Int,
    val country: String,
    val id: Int
)