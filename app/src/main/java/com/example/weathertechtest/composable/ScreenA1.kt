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
import androidx.lifecycle.ViewModel
import androidx.navigation.NavHostController
import com.example.weathertechtest.MainActivity
import com.example.weathertechtest.NavDestinations
import com.example.weathertechtest.WeatherViewModel

// ScreenA1 is a composable with five brief weather reports

@Composable
fun ScreenA1(wvm : WeatherViewModel, navController : NavHostController) {

    val list = wvm.weatherListResponse
    if(list.size <= 0) return

    Card(modifier = Modifier.padding(8.dp, 4.dp).wrapContentSize(),
        shape = RoundedCornerShape(8.dp),
        backgroundColor = Color.White,
        elevation = 4.dp) {

        Column(modifier = Modifier.padding(8.dp))
        {
            WeatherItemBrief(list.get(1))
            WeatherItemBrief(list.get(2))
            WeatherItemBrief(list.get(3))
            WeatherItemBrief(list.get(4))
            WeatherItemBrief(list.get(5))

            Button(onClick = { navController.navigate(NavDestinations.ScreenA2.route) })
            {
                Text(text = "Details")
            }
        }
    }
}