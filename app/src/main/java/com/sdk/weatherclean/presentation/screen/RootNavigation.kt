package com.example.weathercleanarch103.presentation.screen

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.sdk.weatherclean.presentation.main.MainScreen
import com.sdk.weatherclean.util.Graph

@Composable
fun RootNavigation(navHostController: NavHostController) {
    NavHost(
        navController = navHostController,
        startDestination = Graph.Main,
        route = Graph.Root
    ) {
        composable(route =  Graph.Main) {
            MainScreen()
        }
    }
}