package com.sdk.weatherclean.presentation.locations

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sdk.weatherclean.domain.use_case.all.AllUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LocationViewModel @Inject constructor(
    private val allUseCases: AllUseCases
) : ViewModel() {
    private val _state = MutableStateFlow(LocationScreenState())
    val state = _state.asStateFlow()

    init {
        onEvent(LocationEvent.OnSearched("andijan"))
    }
    fun onEvent(event: LocationEvent) {
        if (event is LocationEvent.OnSearched) {
            viewModelScope.launch {
                allUseCases.getCurrentWeatherUseCase(event.query)
                    .onStart {
                        _state.update {
                            it.copy(isLoading = true)
                        }
                    }
                    .catch { th ->
                        _state.update {
                            it.copy(isLoading = false, message = th.message.toString())
                        }
                    }
                    .collect { currentWeather ->
                        _state.update {
                            it.copy(isLoading = false, success = currentWeather)
                        }
                    }
            }
        }
    }
}