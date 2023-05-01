package com.sdk.weatherclean.presentation.screen

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomBarScreen(
    val icon: ImageVector,
    val route: String
) {
    object Locations: BottomBarScreen(
        icon = Icons.Default.LocationOn,
        route = "locations"
    )
    object Favorite: BottomBarScreen(
        icon = Icons.Outlined.Favorite,
        route = "favorite"
    )
    object Settings: BottomBarScreen(
        icon = Icons.Default.Settings,
        route = "settings"
    )
}