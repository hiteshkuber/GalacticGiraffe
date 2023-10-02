package com.hkuber.weatherapp.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.RoundRect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.hkuber.weatherapp.presentation.ui.theme.DarkGreen

@Composable
fun WeatherForeCast(
    state: WeatherState,
    modifier: Modifier = Modifier
) {
    state.weatherInfo?.weatherDataPerDay?.get(0)?.let {

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
                .background(color = DarkGreen, shape = RoundedCornerShape(15.dp))
        ) {
            Text(text = "Today", fontSize = 20.sp, color = Color.White, fontWeight = FontWeight.Bold, modifier = Modifier.padding(15.dp))

            Spacer(modifier = Modifier.height(8.dp))

            LazyRow(content = {
                items(it) {
                    HourlyWeatherDisplay(
                        weatherData = it,
                        textColor = Color.LightGray,
                        modifier = Modifier
                            .height(100.dp)
                            .padding(horizontal = 16.dp)
                    )
                }
            })
        }
    }
}