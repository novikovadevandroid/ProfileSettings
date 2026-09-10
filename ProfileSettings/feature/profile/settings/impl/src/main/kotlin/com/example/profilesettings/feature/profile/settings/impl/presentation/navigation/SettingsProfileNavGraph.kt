package com.example.profilesettings.feature.profile.settings.impl.presentation.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.profilesettings.feature.profile.settings.api.SettingsProfileDependencies
import com.example.profilesettings.feature.profile.settings.api.navigation.SettingsProfileDestination
import com.example.profilesettings.feature.profile.settings.impl.presentation.compose.SettingsProfileRoute

fun NavGraphBuilder.settingsProfileScreen(
    dependencies: SettingsProfileDependencies
) {
    composable(
        route = SettingsProfileDestination.ROUTE
    ) { backStackEntry ->
        SettingsProfileRoute(
            dependencies = dependencies,
            viewModelStoreOwner = backStackEntry
        )
    }
}