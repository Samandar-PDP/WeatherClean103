package com.sdk.weatherclean.domain.repository

import com.sdk.weatherclean.domain.model.CurrentWeather
import kotlinx.coroutines.flow.Flow

interface NetworkRepository {
    suspend fun getCurrentWeather(query: String): Flow<CurrentWeather>
}