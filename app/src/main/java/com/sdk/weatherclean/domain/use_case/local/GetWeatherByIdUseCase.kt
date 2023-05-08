package com.sdk.weatherclean.domain.use_case.local

import com.sdk.weatherclean.domain.model.CurrentWeather
import com.sdk.weatherclean.domain.repository.LocalRepository
import com.sdk.weatherclean.domain.use_case.all.BaseUseCase
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

typealias GetWeatherByIdBaseUseCase = BaseUseCase<Int, Flow<CurrentWeather?>>

class GetWeatherByIdUseCase @Inject constructor(
    private val repository: LocalRepository
): GetWeatherByIdBaseUseCase {
    override suspend fun invoke(parameter: Int): Flow<CurrentWeather?> {
        return repository.getWeatherById(parameter)
    }
}