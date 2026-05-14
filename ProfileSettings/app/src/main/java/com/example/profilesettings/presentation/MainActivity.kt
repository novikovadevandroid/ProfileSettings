package com.example.profilesettings.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.profilesettings.presentation.compose.EditProfileScreen
import com.example.profilesettings.presentation.ui.theme.ProfileSettingsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ProfileSettingsTheme {
                EditProfileScreen()
            }
        }
    }
}