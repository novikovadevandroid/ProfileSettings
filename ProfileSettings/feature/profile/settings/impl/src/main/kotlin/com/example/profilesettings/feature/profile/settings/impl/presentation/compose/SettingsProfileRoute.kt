package com.example.profilesettings.feature.profile.settings.impl.presentation.compose

import androidx.compose.runtime.Composable
import androidx.lifecycle.ViewModelStoreOwner
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.profilesettings.feature.profile.settings.api.SettingsProfileDependencies
import com.example.profilesettings.feature.profile.settings.impl.di.SettingsProfileComponent
import com.example.profilesettings.feature.profile.settings.impl.presentation.viewmodel.SettingsProfileComponentHolderViewModel
import com.example.profilesettings.feature.profile.settings.impl.presentation.viewmodel.SettingsProfileComponentHolderViewModelFactory
import com.example.profilesettings.feature.profile.settings.impl.presentation.viewmodel.SettingsProfileViewModel

@Composable
fun SettingsProfileRoute(
    dependencies: SettingsProfileDependencies,
    viewModelStoreOwner: ViewModelStoreOwner
) {

    val componentHolder: SettingsProfileComponentHolderViewModel = viewModel(
        viewModelStoreOwner = viewModelStoreOwner,
        factory = SettingsProfileComponentHolderViewModelFactory(dependencies)
    )

    val component: SettingsProfileComponent = componentHolder.component

    val viewModel: SettingsProfileViewModel = viewModel(
        viewModelStoreOwner = viewModelStoreOwner,
        factory = component.viewModelFactory()
    )

    EditProfileScreen(viewModel = viewModel)
}