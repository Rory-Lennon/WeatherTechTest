package com.example.weathertechtest

import android.Manifest
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.content.res.Resources
import android.os.Bundle
import android.util.AttributeSet
import android.util.Log
import android.view.ActionMode
import android.view.View
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.app.ActivityCompat
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.weathertechtest.composable.*
import com.example.weathertechtest.ui.theme.WeatherTechTestTheme
import com.google.android.gms.location.LocationServices

// The main activity checks for location permissions and queries the json data
// for weather information after the location query has returned

class MainActivity : ComponentActivity() {

    val weatherViewModel by viewModels<WeatherViewModel>()
    lateinit var navController : NavHostController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this)
        if (ActivityCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_FINE_LOCATION) !=
            PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED)
        {
            Log.d("MainActivity ", "No Location Permission")
        }
        else {
            val task = fusedLocationProviderClient.lastLocation
            task.addOnSuccessListener {
                weatherViewModel.getWeatherList(it.latitude, it.longitude, resources)

//                val id = resources.getIdentifier("a01d", "drawable", packageName)
//                Log.d("MainActivity ", "xxxxxxxxxxxxxxxxxxxxxxxxxxx res id $id")
            }
        }
        setContent {
            WeatherTechTestTheme {
                navController = rememberNavController()
                setupNavGraph(weatherViewModel, navController)
            }
        }
    }
    fun getResourceIDs(){
        for (item in weatherViewModel.weatherListResponse){
            val id = resources.getIdentifier(item.weather.icon, "drawable", packageName)
            item.icon_res_id = id
            val iconCode = item.weather.icon
            Log.d("MainActivity ", "xxxxxxxxxxxxxxxxxxxxxxxxxxx res id $id icon code $iconCode")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    WeatherTechTestTheme {

    }
}
