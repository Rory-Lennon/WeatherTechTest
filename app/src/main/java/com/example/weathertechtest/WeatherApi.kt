package com.example.weathertechtest

import com.example.weathertechtest.model.DataRoot
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

// interface for getting the json data from weatherbit

interface WeatherApi {

    @GET("?key=a9ff03b3cd404cf98d3c94dfc571e6c0")
    suspend fun getWeather(@Query("lat") lat: Double, @Query("lon") lon: Double) : DataRoot

    companion object {
        var weatherApi : WeatherApi? = null
        fun getInstance() : WeatherApi {
            if (weatherApi == null) {
                weatherApi = Retrofit.Builder()
                    .baseUrl("https://api.weatherbit.io/v2.0/forecast/daily/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build().create(WeatherApi::class.java)
            }
            return weatherApi!!
        }
    }
}