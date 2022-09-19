package com.example.weathertechtest.composable

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.weathertechtest.NavDestinations
import com.example.weathertechtest.WeatherViewModel

// ScreenC2 is a composable with five weather reports

@Composable
fun ScreenC2(wvm : WeatherViewModel, navController : NavHostController) {
    val list = wvm.weatherListResponse
    if(list.size <= 0) return

    Surface(modifier = Modifier.fillMaxSize(), color = Color.Green)
    {
        LazyColumn() {
            item {
                Button(modifier = Modifier.padding(8.dp, 4.dp), onClick = { navController.navigate(NavDestinations.Home.route) })
                {
                    Text(text = "Home")
                }
            }
            item {
                WeatherItem(list.get(11))
            }
            item {
                WeatherItem(list.get(12))
            }
            item {
                WeatherItem(list.get(13))
            }
            item {
                WeatherItem(list.get(14))
            }
            item {
                WeatherItem(list.get(15))
            }
        }
    }
}