package com.hkuber.weatherapp.data.repository

import com.hkuber.weatherapp.data.mappers.toWeatherInfo
import com.hkuber.weatherapp.data.remote.WeatherApi
import com.hkuber.weatherapp.domain.repository.WeatherRepository
import com.hkuber.weatherapp.domain.util.Resource
import com.hkuber.weatherapp.domain.weather.WeatherInfo
import javax.inject.Inject

class WeatherRepositoryImpl @Inject constructor(
    private val api: WeatherApi
) : WeatherRepository {
    override suspend fun getWeatherData(
        latitude: Double,
        longitude: Double
    ): Resource<WeatherInfo> {
        return  try {
            Resource.Success(data = api.getWeatherData(lat = latitude, lon = longitude).toWeatherInfo())
        } catch (e: Exception) {
            Resource.Error(message = e.message ?: "An unknown error occurred")
        }
    }
}