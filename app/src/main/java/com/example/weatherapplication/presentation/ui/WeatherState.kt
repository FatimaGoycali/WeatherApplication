package com.example.weatherapplication.presentation.ui

import com.example.weatherapplication.domain.weather.WeatherInfo

data class WeatherState(
    val weatherInfo: WeatherInfo? = null,
    val isLoading: Boolean = false,
    val error: String? = null
)
