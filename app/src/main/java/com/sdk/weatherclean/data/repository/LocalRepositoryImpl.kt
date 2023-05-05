package com.sdk.weatherclean.data.repository

import com.sdk.weatherclean.data.database.WeatherDao
import com.sdk.weatherclean.domain.model.CurrentWeather
import com.sdk.weatherclean.domain.repository.LocalRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class LocalRepositoryImpl @Inject constructor(
    private val dao: WeatherDao
): LocalRepository {
    override suspend fun saveWeather(currentWeather: CurrentWeather) {
        dao.saveWeather(currentWeather)
    }

    override suspend fun deleteWeather(id: Int) {
        dao.deleteById(id)
    }

    override fun getWeatherById(id: Int): Flow<CurrentWeather?> {
        return dao.getWeatherId(id)
    }

    override fun getWeatherList(): Flow<List<CurrentWeather>> {
        return dao.getAllFavoriteWeathers()
    }
}