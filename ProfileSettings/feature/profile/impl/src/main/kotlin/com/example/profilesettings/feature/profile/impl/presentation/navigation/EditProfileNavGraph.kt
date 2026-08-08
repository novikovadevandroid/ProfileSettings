package com.example.profilesettings.feature.profile.impl.presentation.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.profilesettings.feature.profile.api.ProfileDependencies
import com.example.profilesettings.feature.profile.api.navigation.EditProfileDestination
import com.example.profilesettings.feature.profile.impl.presentation.compose.EditProfileRoute

fun NavGraphBuilder.editProfileScreen(
    dependencies: ProfileDependencies
) {
    composable(
        route = EditProfileDestination.ROUTE
    ) { backStackEntry ->
        EditProfileRoute(
            dependencies = dependencies,
            viewModelStoreOwner = backStackEntry
        )
    }
}