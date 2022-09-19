package com.example.weathertechtest

// NavDestinations used for identifying where to navigate to

sealed class NavDestinations(val route : String){

    object Home : NavDestinations(route = "screen_home")
    object ScreenA1 : NavDestinations(route = "screen_A1")
    object ScreenB1 : NavDestinations(route = "screen_B1")
    object ScreenC1 : NavDestinations(route = "screen_C1")
    object ScreenA2 : NavDestinations(route = "screen_A2")
    object ScreenB2 : NavDestinations(route = "screen_B2")
    object ScreenC2 : NavDestinations(route = "screen_C2")
}
