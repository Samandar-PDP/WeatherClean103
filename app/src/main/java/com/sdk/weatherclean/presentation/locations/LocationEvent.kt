package com.sdk.weatherclean.presentation.locations

sealed class LocationEvent {
    data class OnSearched(val query: String): LocationEvent()
}