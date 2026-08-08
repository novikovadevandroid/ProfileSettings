package com.example.profilesettings.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.rememberNavController
import com.example.profilesettings.ProfileSettingsApp
import com.example.profilesettings.presentation.navigation.AppNavHost

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val appComponent = (application as ProfileSettingsApp).component

        setContent {
            val navController = rememberNavController()

            AppNavHost(
                navController = navController,
                dependencies = appComponent
            )
        }
    }
}