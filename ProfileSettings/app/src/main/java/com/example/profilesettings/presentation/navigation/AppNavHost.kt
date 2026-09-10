package com.example.profilesettings.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.example.profilesettings.feature.profile.page.api.ProfilePageDependencies
import com.example.profilesettings.feature.profile.page.api.navigation.ProfilePageDestination
import com.example.profilesettings.feature.profile.page.impl.presentation.navigation.profilePageScreen
import com.example.profilesettings.feature.profile.settings.api.SettingsProfileDependencies
import com.example.profilesettings.feature.profile.settings.api.navigation.SettingsProfileDestination
import com.example.profilesettings.feature.profile.settings.impl.presentation.navigation.settingsProfileScreen

@Composable
fun AppNavHost(
    navController: NavHostController,
    profilePageDependencies: ProfilePageDependencies,
    settingsProfileDependencies: SettingsProfileDependencies
) {
    NavHost(
        navController = navController,
        startDestination = ProfilePageDestination.ROUTE
    ) {
        profilePageScreen(profilePageDependencies, navController)

        settingsProfileScreen(settingsProfileDependencies)
    }
}