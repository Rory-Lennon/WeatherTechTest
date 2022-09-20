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
import java.text.DateFormat
import java.util.*

// WeatherItemBrief is a less detailed weather report card used in
// ScreenA1, ScreenB1 and Screen C1 composables

@Composable
fun WeatherItemBrief(weatherInfo: WeatherInfo) {

    val cal : Calendar = Calendar.getInstance()
    cal.add(Calendar.DAY_OF_WEEK, weatherInfo.listNumber)
    val future = cal.time
    val dateStr = DateFormat.getDateInstance(DateFormat.FULL).format(future)

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
                    .weight(2f)
            )
            {
                Text(
                    text = dateStr,
                    style = MaterialTheme.typography.subtitle1,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = weatherInfo.weather.description,
                    style = MaterialTheme.typography.subtitle1,
                    fontWeight = FontWeight.Bold
                )
            }
            Column(verticalArrangement = Arrangement.Center, modifier = Modifier
                .padding(8.dp)
                .fillMaxHeight()
                .weight(1f)
            )
            {
                val resID = weatherInfo.GetResID()
                if(resID != 0) {
                    Image(
                        painter = painterResource(resID),
                        contentDescription = null,
                        modifier = Modifier
                            .fillMaxSize()
                    )
                }
            }
        }
    }
}