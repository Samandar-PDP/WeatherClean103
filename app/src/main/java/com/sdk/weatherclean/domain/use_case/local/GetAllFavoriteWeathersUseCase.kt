package com.sdk.weatherclean.domain.use_case.local

import com.sdk.weatherclean.domain.model.CurrentWeather
import com.sdk.weatherclean.domain.repository.LocalRepository
import com.sdk.weatherclean.domain.use_case.all.BaseUseCase
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

typealias GetAllFavoriteWeathersBaseUseCase = BaseUseCase<Unit,Flow<List<CurrentWeather>>>

class GetAllFavoriteWeathersUseCase @Inject constructor(
    private val repository: LocalRepository
): GetAllFavoriteWeathersBaseUseCase {
    override suspend fun invoke(parameter: Unit): Flow<List<CurrentWeather>> {
        return repository.getWeatherList()
    }
}