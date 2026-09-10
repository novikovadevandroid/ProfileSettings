package com.example.profilesettings.feature.profile.page.impl.presentation.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.example.profilesettings.feature.profile.page.api.ProfilePageDependencies
import com.example.profilesettings.feature.profile.page.api.navigation.ProfilePageDestination
import com.example.profilesettings.feature.profile.page.impl.presentation.compose.ProfilePageRoute
import com.example.profilesettings.feature.profile.settings.api.navigation.SettingsProfileDestination

fun NavGraphBuilder.profilePageScreen(
    dependencies: ProfilePageDependencies,
    navController: NavHostController
) {
    composable(
        route = ProfilePageDestination.ROUTE
    ) { backStackEntry ->
        ProfilePageRoute(
            viewModelStoreOwner = backStackEntry,
            dependencies = dependencies,
            onOpenSettings = {
                navController.navigate(SettingsProfileDestination.ROUTE)
            }
        )
    }
}