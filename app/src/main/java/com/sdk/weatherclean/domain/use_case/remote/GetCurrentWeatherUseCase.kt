package com.sdk.weatherclean.domain.use_case.remote

import com.sdk.weatherclean.domain.model.CurrentWeather
import com.sdk.weatherclean.domain.repository.NetworkRepository
import com.sdk.weatherclean.domain.use_case.all.BaseUseCase
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

typealias GetCurrentWeatherBaseUseCase = BaseUseCase<String, Flow<CurrentWeather>>

class GetCurrentWeatherUseCase @Inject constructor(
    private val repository: NetworkRepository
): GetCurrentWeatherBaseUseCase {
    override suspend fun invoke(parameter: String): Flow<CurrentWeather> {
        return repository.getCurrentWeather(parameter)
    }
}