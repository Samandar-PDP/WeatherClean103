package com.sdk.weatherclean.domain.use_case.all

import com.sdk.weatherclean.domain.use_case.remote.GetCurrentWeatherUseCase

data class AllUseCases(
    val getCurrentWeatherUseCase: GetCurrentWeatherUseCase
)