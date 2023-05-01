package com.sdk.weatherclean.data.repository

import com.sdk.weatherclean.data.mapper.toCurrentWeather
import com.sdk.weatherclean.data.remote.WeatherService
import com.sdk.weatherclean.domain.model.CurrentWeather
import com.sdk.weatherclean.domain.repository.NetworkRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class NetworkRepositoryImpl @Inject constructor(
    private val service: WeatherService
) : NetworkRepository {
    override suspend fun getCurrentWeather(query: String): Flow<CurrentWeather> = flow {
        service.getCurrentWeather(query).body()?.let {
            emit(it.toCurrentWeather())
        }
    }
}