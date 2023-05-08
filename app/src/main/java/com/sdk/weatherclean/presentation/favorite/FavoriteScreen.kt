package com.sdk.weatherclean.presentation.favorite

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import com.sdk.weatherclean.R
import com.sdk.weatherclean.presentation.component.AppAnimation
import com.sdk.weatherclean.presentation.component.FavoriteItem

@Composable
fun FavoriteScreen(
    uiState: FavoriteState,
    onEvent: (FavoriteEvent) -> Unit
) {
    if (uiState.isLoading) {
        AppAnimation(id = R.raw.loading)
    }
    LazyColumn(
        contentPadding = PaddingValues(8.dp)
    ) {
        items(uiState.weatherList, key = {
            it.id
        }) {
            FavoriteItem(currentWeather = it, onDelete = {
                onEvent(FavoriteEvent.OnWeatherDelete(it.id))
            })
        }
    }
}