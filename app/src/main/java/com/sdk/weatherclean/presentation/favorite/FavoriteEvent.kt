package com.sdk.weatherclean.presentation.favorite

sealed interface FavoriteEvent {
    data class OnWeatherDelete(val id: Int): FavoriteEvent
}