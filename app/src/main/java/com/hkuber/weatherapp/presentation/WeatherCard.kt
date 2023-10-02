package com.hkuber.weatherapp.presentation

import android.text.style.BackgroundColorSpan
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.hkuber.weatherapp.R
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment
import java.time.format.DateTimeFormatter

@Composable
fun WeatherCard(
    state: WeatherState,
    backgroundColor: Color,
    modifier: Modifier = Modifier
) {

    state.weatherInfo?.currentWeatherDetail?.let {
        Card(
            backgroundColor = backgroundColor,
            shape = RoundedCornerShape(10.dp),
            modifier = modifier.padding(16.dp)
        ) {
            Column(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Today ${it.time.format(DateTimeFormatter.ofPattern("HH:mm"))}",
                    modifier = Modifier.align(Alignment.End),
                    color = Color.White
                )

                Spacer(modifier = Modifier.height(16.dp))

                Image(
                    painter = painterResource(id = it.weatherType.iconRes),
                    contentDescription = "",
                    modifier = Modifier.width(200.dp)
                )

                Spacer(modifier = Modifier.height(16.dp))

                Text(text = "${it.temperatureCelsius}°C", fontSize = 50.sp, color = Color.White)

                Spacer(modifier = Modifier.height(16.dp))

                Text(text = "${it.weatherType.weatherDesc}", fontSize = 20.sp, color = Color.White)

                Spacer(modifier = Modifier.height(32.dp))

                Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceAround) {
                    WeatherDataDisplay(value = it.pressure.toInt(), unit = "hpa", icon = ImageVector.vectorResource(id = R.drawable.ic_pressure), iconTint = Color.White, textState = TextStyle(color = Color.White))
                    WeatherDataDisplay(value = it.humidity.toInt(), unit = "%", icon = ImageVector.vectorResource(id = R.drawable.ic_drop), iconTint = Color.White, textState = TextStyle(color = Color.White))
                    WeatherDataDisplay(value = it.windSpeed.toInt(), unit = "km/h", icon = ImageVector.vectorResource(id = R.drawable.ic_wind), iconTint = Color.White, textState = TextStyle(color = Color.White))
                }
            }
        }
    }

}