package com.example.weathertechtest.composable

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.weathertechtest.NavDestinations
import com.example.weathertechtest.WeatherViewModel

// ScreenB1 is a composable with five brief weather reports

@Composable
fun ScreenB1(wvm : WeatherViewModel, navController : NavHostController) {
    val list = wvm.weatherListResponse
    if(list.size <= 0) return

    Card(modifier = Modifier.padding(8.dp, 4.dp).wrapContentSize(),
        shape = RoundedCornerShape(8.dp),
        backgroundColor = Color.White,
        elevation = 4.dp) {

        Column(modifier = Modifier.padding(8.dp))
        {
            WeatherItemBrief(list.get(6))
            WeatherItemBrief(list.get(7))
            WeatherItemBrief(list.get(8))
            WeatherItemBrief(list.get(9))
            WeatherItemBrief(list.get(10))

            Button(onClick = { navController.navigate(NavDestinations.ScreenB2.route) })
            {
                Text(text = "Details")
            }
        }
    }
}