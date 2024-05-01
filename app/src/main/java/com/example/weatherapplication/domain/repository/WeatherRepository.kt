package com.example.weatherapplication.domain.repository

import com.example.weatherapplication.domain.weather.WeatherInfo
import com.plcoding.weatherapp.domain.util.Resource

interface WeatherRepository{
    suspend fun getWeatherData(lat :Double, long:Double) :Resource<WeatherInfo>
}