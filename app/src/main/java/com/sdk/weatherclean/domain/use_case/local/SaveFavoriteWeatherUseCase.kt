package com.sdk.weatherclean.domain.use_case.local

import com.sdk.weatherclean.domain.model.CurrentWeather
import com.sdk.weatherclean.domain.repository.LocalRepository
import com.sdk.weatherclean.domain.use_case.all.BaseUseCase
import javax.inject.Inject

typealias SaveFavoriteWeatherBaseUseCase = BaseUseCase<CurrentWeather,Unit>

class SaveFavoriteWeatherUseCase @Inject constructor(
    private val repository: LocalRepository
): SaveFavoriteWeatherBaseUseCase {
    override suspend fun invoke(parameter: CurrentWeather) {
        repository.saveWeather(parameter)
    }
}