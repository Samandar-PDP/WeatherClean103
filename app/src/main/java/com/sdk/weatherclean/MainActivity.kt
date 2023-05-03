package com.sdk.weatherclean

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.sdk.weatherclean.presentation.screen.RootNavigation
import com.sdk.weatherclean.presentation.theme.WeatherCleanTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WeatherCleanTheme {
                val navController = rememberNavController()
                RootNavigation(navHostController = navController)
            }
        }
    }
}

