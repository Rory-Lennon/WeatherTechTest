package com.example.weathertechtest.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.weathertechtest.model.WeatherInfo
import com.example.weathertechtest.R

// WeatherItem is a detailed weather report card used at the top of the home screen
// and also in ScreenA2, ScreenB2 and ScreenC2 composables

@Composable
fun WeatherItem(weatherInfo: WeatherInfo) {

    Card(modifier = Modifier
        .padding(8.dp, 4.dp)
        .fillMaxWidth(), shape = RoundedCornerShape(8.dp))
    {
        Row() {

            Column(
                verticalArrangement = Arrangement.Center,
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxHeight()
            )
            {
                Text(
                    text = "Location " + weatherInfo.city_name,
                    style = MaterialTheme.typography.subtitle1,
                    fontWeight = FontWeight.Bold
                )

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
                Text(
                    text = "Icon " + weatherInfo.weather.icon,
                    style = MaterialTheme.typography.body1,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )
                Text(
                    text = "Current Temp " + weatherInfo.temp.toString() + " Degrees",
                    style = MaterialTheme.typography.body1,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )
                Text(
                    text = "Max Temp " + weatherInfo.max_temp.toString() + " Degrees",
                    style = MaterialTheme.typography.body1,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )
                Text(
                    text = "Min Temp " + weatherInfo.min_temp.toString() + " Degrees",
                    style = MaterialTheme.typography.body1,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )
            }
            Column(verticalArrangement = Arrangement.Center, modifier = Modifier
                .padding(8.dp)
                .fillMaxHeight())
            {
                val resID = weatherInfo.icon_res_id
                if(resID != 0) {
                    Image(
                        painter = painterResource(weatherInfo.icon_res_id),
                        contentDescription = null)
                }
            }
        }
    }
}