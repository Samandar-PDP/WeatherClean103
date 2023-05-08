package com.sdk.weatherclean.presentation.locations

import com.sdk.weatherclean.domain.model.CurrentWeather

sealed class LocationEvent {
    data class OnSearched(val query: String): LocationEvent()
    data class OnUpdateWeather(val currentWeather: CurrentWeather): LocationEvent()
}