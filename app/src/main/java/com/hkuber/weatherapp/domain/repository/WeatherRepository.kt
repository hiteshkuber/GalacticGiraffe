package com.hkuber.weatherapp.domain.repository

import com.hkuber.weatherapp.domain.util.Resource
import com.hkuber.weatherapp.domain.weather.WeatherInfo

interface WeatherRepository {

    suspend fun getWeatherData(latitude: Double, longitude: Double): Resource<WeatherInfo>
}