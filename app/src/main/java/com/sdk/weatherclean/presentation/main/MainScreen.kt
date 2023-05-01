package com.sdk.weatherclean.presentation.main

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MediumTopAppBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.sdk.weatherclean.presentation.component.BottomBar
import com.sdk.weatherclean.presentation.component.CustomTopBar
import com.sdk.weatherclean.presentation.favorite.FavoriteScreen
import com.sdk.weatherclean.presentation.locations.LocationsScreen
import com.sdk.weatherclean.presentation.screen.BottomBarScreen
import com.sdk.weatherclean.presentation.settings.SettingScreen
import com.sdk.weatherclean.util.Graph

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen() {
    val navHostController = rememberNavController()
    val current by navHostController.currentBackStackEntryAsState()
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            CustomTopBar(
                title = current?.destination?.route.toString(),
                isBackIconVisible = false,
                onClick = {
                    navHostController.popBackStack()
                }
            )
        },
        bottomBar = {
            BottomBar(navHostController = navHostController)
        }
    ) { padding ->
        NavHost(
            modifier = Modifier.padding(padding),
            navController = navHostController,
            route = Graph.Main,
            startDestination = BottomBarScreen.Locations.route
        ) {
            composable(route = BottomBarScreen.Locations.route) {
                LocationsScreen()
            }
            composable(route = BottomBarScreen.Favorite.route) {
                FavoriteScreen()
            }
            composable(route = BottomBarScreen.Settings.route) {
                SettingScreen()
            }
        }
    }
}