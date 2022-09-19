package com.example.weathertechtest.model

// The DataRoot class is the start of the weather data tree
// It has a list of WeatherInfo for 16 days

data class DataRoot(
    val data : List<WeatherInfo>,
    val city_name : String
)