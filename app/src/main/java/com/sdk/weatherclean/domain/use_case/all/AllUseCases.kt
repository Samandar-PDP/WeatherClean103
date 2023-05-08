package com.sdk.weatherclean.domain.use_case.all

import com.sdk.weatherclean.domain.use_case.local.DeleteWeatherByIdUseCase
import com.sdk.weatherclean.domain.use_case.local.GetAllFavoriteWeathersUseCase
import com.sdk.weatherclean.domain.use_case.local.GetThemeUseCase
import com.sdk.weatherclean.domain.use_case.local.GetWeatherByIdUseCase
import com.sdk.weatherclean.domain.use_case.local.SaveFavoriteWeatherUseCase
import com.sdk.weatherclean.domain.use_case.local.SaveThemeUseCase
import com.sdk.weatherclean.domain.use_case.remote.GetCurrentWeatherUseCase

data class AllUseCases(
    val getCurrentWeatherUseCase: GetCurrentWeatherUseCase,
    val saveFavoriteWeatherUseCase: SaveFavoriteWeatherUseCase,
    val getWeatherByIdUseCase: GetWeatherByIdUseCase,
    val deleteWeatherByIdUseCase: DeleteWeatherByIdUseCase,
    val getAllFavoriteWeathersUseCase: GetAllFavoriteWeathersUseCase,
    val saveThemeUseCase: SaveThemeUseCase,
    val getThemeUseCase: GetThemeUseCase
)