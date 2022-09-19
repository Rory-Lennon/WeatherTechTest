package com.example.weathertechtest.composable

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.weathertechtest.model.WeatherInfo

// WeatherItemBrief is a less detailed weather report card used in
// ScreenA1, ScreenB1 and Screen C1 composables

@Composable
fun WeatherItemBrief(weatherInfo: WeatherInfo) {

    Card(modifier = Modifier.padding(8.dp, 4.dp), shape = RoundedCornerShape(8.dp))
    {
        Column(verticalArrangement = Arrangement.Center, modifier = Modifier.padding(8.dp).fillMaxWidth())
        {
            Text(
                text = "Day " + weatherInfo.listNumber,
                style = MaterialTheme.typography.subtitle1,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = weatherInfo.weather.description,
                style = MaterialTheme.typography.subtitle1,
                fontWeight = FontWeight.Bold
            )
        }
    }
}