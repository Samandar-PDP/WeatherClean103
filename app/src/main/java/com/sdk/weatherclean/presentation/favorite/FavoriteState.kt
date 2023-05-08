package com.sdk.weatherclean.presentation.favorite

import com.sdk.weatherclean.domain.model.CurrentWeather

data class FavoriteState(
    val isLoading: Boolean = false,
    val weatherList: List<CurrentWeather> = emptyList()
)