package com.hkuber.weatherapp.data.mappers

import com.hkuber.weatherapp.data.remote.WeatherDto
import com.hkuber.weatherapp.data.remote.WeatherViewData
import com.hkuber.weatherapp.domain.weather.WeatherData
import com.hkuber.weatherapp.domain.weather.WeatherInfo
import com.hkuber.weatherapp.domain.weather.WeatherType
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter


private data class IndexedWeatherData(
    val index: Int,
    val weatherData: WeatherData
)
fun WeatherViewData.toWeatherDataMap(): Map<Int, List<WeatherData>> {
    return timeList.mapIndexed{ index, time ->
        val temperature = temperatureList[index]
        val windSpeed = windSpeedList[index]
        val humidity = humidityList[index]
        val code = codeList[index]
        val pressure = pressureList[index]

        IndexedWeatherData(
            index = index,
            weatherData = WeatherData(
                time = LocalDateTime.parse(time, DateTimeFormatter.ISO_DATE_TIME),
                temperatureCelsius = temperature,
                pressure = pressure,
                windSpeed = windSpeed,
                humidity = humidity,
                weatherType = WeatherType.fromWMO(code)
            )
        )
    }.groupBy {
        it.index / 24
    }.mapValues {
        it.value.map { it.weatherData }
    }
}

fun WeatherDto.toWeatherInfo() : WeatherInfo {
    val weatherDataMap = weatherDto.toWeatherDataMap()
    val now = LocalDateTime.now()
    val currentWeatherDetail = weatherDataMap[0]?.find{
        val hour = if (now.minute < 30) {
            now.hour
        } else {
            now.hour + 1
        }

        it.time.hour == hour
    }

    return WeatherInfo(
        weatherDataPerDay = weatherDataMap,
        currentWeatherDetail = currentWeatherDetail
    )

}