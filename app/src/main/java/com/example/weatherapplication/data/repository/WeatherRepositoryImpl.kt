package com.example.weatherapplication.data.repository

import com.example.weatherapplication.data.mappers.toWeatherInfo
import com.example.weatherapplication.data.remote.WeatherApi
import com.example.weatherapplication.domain.repository.WeatherRepository
import com.example.weatherapplication.domain.weather.WeatherInfo
import com.plcoding.weatherapp.domain.util.Resource
import javax.inject.Inject

class WeatherRepositoryImpl @Inject constructor(
    private val api: WeatherApi
) : WeatherRepository {

    override suspend fun getWeatherData(lat: Double, long: Double): Resource<WeatherInfo> {
        return try {
            Resource.Success(
                data = api.getWeatherData(
                    lat = lat,
                    long = long
                ).toWeatherInfo()
            )


        } catch (e: Exception) {
            e.printStackTrace()
            Resource.Error(e.message ?: "A unknown error occurred.")
        }
    }
}