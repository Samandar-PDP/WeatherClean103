package com.sdk.weatherclean.presentation.locations

import com.sdk.weatherclean.domain.model.CurrentWeather

data class LocationScreenState(
    val isLoading: Boolean = false,
    val message: String = "",
    val success: CurrentWeather? = null,
    val isLiked: Boolean = false
)