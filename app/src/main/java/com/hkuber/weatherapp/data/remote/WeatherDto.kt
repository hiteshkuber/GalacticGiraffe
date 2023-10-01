package com.hkuber.weatherapp.data.remote

import com.squareup.moshi.Json

data class WeatherDto(

    @field:Json(name = "hourly")
    val weatherDto: WeatherDto
)
