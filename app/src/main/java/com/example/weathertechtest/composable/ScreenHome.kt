package com.example.weathertechtest.composable

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import com.example.weathertechtest.WeatherViewModel

// The home screen is a composable with a detailed weather report at the top, and
// a scrollable weather forecast summary at the bottom

@Composable
fun ScreenHome(wvm : WeatherViewModel, navController : NavHostController)
{
    val list = wvm.weatherListResponse
    if(list.size <= 0) return
    val featuredInfo = wvm.weatherFeatured

    Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally)
    {
        Surface(modifier = Modifier.weight(1f).fillMaxWidth(), color = Color.LightGray)
        {
            WeatherItem(featuredInfo!!)
        }
        Surface(modifier = Modifier.weight(3f).fillMaxWidth(), color = Color.LightGray)
        {
            LazyColumn(){
                item {
                    ScreenA1(wvm, navController)
                }
                item {
                    ScreenB1(wvm, navController)
                }
                item {
                    ScreenC1(wvm, navController)
                }
            }
        }
    }
}