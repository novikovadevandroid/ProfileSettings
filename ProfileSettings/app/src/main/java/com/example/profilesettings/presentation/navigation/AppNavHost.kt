package com.example.profilesettings.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.example.profilesettings.feature.profile.api.ProfileDependencies
import com.example.profilesettings.feature.profile.api.navigation.EditProfileDestination
import com.example.profilesettings.feature.profile.impl.presentation.navigation.editProfileScreen

@Composable
fun AppNavHost(
    navController: NavHostController,
    dependencies: ProfileDependencies
) {
    NavHost(
        navController = navController,
        startDestination = EditProfileDestination.ROUTE
    ) {
        editProfileScreen(dependencies)
    }
}