package com.example.profilesettings.feature.profile.page.impl.presentation.compose

import androidx.compose.runtime.Composable
import androidx.lifecycle.ViewModelStoreOwner
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.profilesettings.feature.profile.page.api.ProfilePageDependencies
import com.example.profilesettings.feature.profile.page.impl.di.ProfilePageComponent
import com.example.profilesettings.feature.profile.page.impl.presentation.viewmodel.ProfilePageComponentHolderViewModel
import com.example.profilesettings.feature.profile.page.impl.presentation.viewmodel.ProfilePageComponentHolderViewModelFactory
import com.example.profilesettings.feature.profile.page.impl.presentation.viewmodel.ProfilePageViewModel

@Composable
fun ProfilePageRoute(
    viewModelStoreOwner: ViewModelStoreOwner,
    dependencies: ProfilePageDependencies,
    onOpenSettings: () -> Unit
) {

    val componentHolder: ProfilePageComponentHolderViewModel = viewModel(
        viewModelStoreOwner = viewModelStoreOwner,
        factory = ProfilePageComponentHolderViewModelFactory(dependencies)
    )

    val component: ProfilePageComponent = componentHolder.component

    val viewModel: ProfilePageViewModel = viewModel(
        viewModelStoreOwner = viewModelStoreOwner,
        factory = component.viewModelFactory()
    )

    ProfilePageScreen(
        viewModel = viewModel,
        onOpenSettings = onOpenSettings
    )
}