package com.sdk.weatherclean.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.sdk.weatherclean.domain.model.CurrentWeather

@Database(entities = [CurrentWeather::class], version = 1, exportSchema = false)
abstract class WeatherDatabase: RoomDatabase() {
    abstract val dao: WeatherDao
}