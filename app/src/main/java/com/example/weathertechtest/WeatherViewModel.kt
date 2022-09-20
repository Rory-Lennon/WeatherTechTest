package com.example.weathertechtest

import android.app.Application
import android.app.PendingIntent.getActivity
import android.content.res.Resources
import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weathertechtest.model.WeatherInfo
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.launch
import com.example.weathertechtest.R

// The ViewModel maintains the data source if the view is removed.
// getWeatherList() gets the json data and inserts it into a set of
// data objects arranged to reflect the arrangement of the data on
// weatherbit...

class WeatherViewModel : ViewModel() {

    var weatherFeatured : WeatherInfo? = null
    var weatherListResponse : List<WeatherInfo> by mutableStateOf(listOf())
    var errMessage : String by mutableStateOf("")

    fun getWeatherList(lat : Double, lon : Double, resources : Resources) {

        viewModelScope.launch {
            val weatherAPI = WeatherApi.getInstance()
            try {
                val dataRoot = weatherAPI.getWeather(lat, lon)
                weatherListResponse = dataRoot.data
                if(weatherListResponse.size > 0){
                    var i = 0
                    for (item in weatherListResponse) {
                        item.city_name = dataRoot.city_name
                        item.listNumber = i
                        i++
                    }
                    weatherFeatured = weatherListResponse.get(0)
                }
            }
            catch(e:Exception){
                errMessage = e.message.toString()
                Log.e("WeatherViewModel ", errMessage)
            }
        }
    }
}


