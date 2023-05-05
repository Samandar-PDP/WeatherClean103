package com.sdk.weatherclean.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
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
    val wind: Double,
    val country: String,
    val id: Int
) {
    @PrimaryKey(autoGenerate = true)
    val roomId: Int = 0
}