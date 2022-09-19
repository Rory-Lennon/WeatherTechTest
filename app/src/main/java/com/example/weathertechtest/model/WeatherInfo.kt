package com.example.weathertechtest.model

// WeatherInfo is the dataset used for information in WeatherItem and
// WeatherItemBrief composables

data class WeatherInfo(
    var temp : Double = 0.0,
    var min_temp : Double = 0.0,
    var max_temp : Double = 0.0,
    val weather : WeatherSubList,
    var listNumber : Int = 0,
    var city_name : String = "",
    var icon_res_id : Int = 0
)


