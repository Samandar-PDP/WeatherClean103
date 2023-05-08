package com.sdk.weatherclean

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.rememberNavController
import com.sdk.weatherclean.presentation.screen.RootNavigation
import com.sdk.weatherclean.presentation.settings.SettingViewModel
import com.sdk.weatherclean.presentation.theme.WeatherCleanTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val settingViewModel: SettingViewModel = hiltViewModel()
            val state by settingViewModel.themeState.collectAsState()
            val index = when(state) {
                0 -> isSystemInDarkTheme()
                1 -> false
                else -> true
            }
            WeatherCleanTheme(
                darkTheme = index
            ) {
                val navController = rememberNavController()
                RootNavigation(navHostController = navController)
            }
        }
    }
}

