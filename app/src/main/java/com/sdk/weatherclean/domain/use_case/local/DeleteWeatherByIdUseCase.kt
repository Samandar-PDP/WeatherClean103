package com.sdk.weatherclean.domain.use_case.local

import com.sdk.weatherclean.domain.repository.LocalRepository
import com.sdk.weatherclean.domain.use_case.all.BaseUseCase
import javax.inject.Inject

typealias DeleteWeatherByIdBaseUseCase = BaseUseCase<Int, Unit>

class DeleteWeatherByIdUseCase @Inject constructor(
    private val localRepository: LocalRepository
): DeleteWeatherByIdBaseUseCase {
    override suspend fun invoke(parameter: Int) {
        localRepository.deleteWeather(parameter)
    }
}