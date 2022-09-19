package com.example.weathertechtest.composable

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.example.weathertechtest.NavDestinations
import com.example.weathertechtest.WeatherViewModel

// The NavGraph maps button clicks to different screen view destinations

@Composable
fun setupNavGraph(wvm : WeatherViewModel, navController : NavHostController){

    NavHost(navController = navController, startDestination = NavDestinations.Home.route){
        composable(route = NavDestinations.Home.route){
            ScreenHome(wvm, navController)
        }
        composable(route = NavDestinations.ScreenA1.route){
            ScreenA1(wvm, navController)
        }
        composable(route = NavDestinations.ScreenB1.route){
            ScreenB1(wvm, navController)
        }
        composable(route = NavDestinations.ScreenC1.route){
            ScreenC1(wvm, navController)
        }
        composable(route = NavDestinations.ScreenA2.route){
            ScreenA2(wvm, navController)
        }
        composable(route = NavDestinations.ScreenB2.route){
            ScreenB2(wvm, navController)
        }
        composable(route = NavDestinations.ScreenC2.route){
            ScreenC2(wvm, navController)
        }
    }
}