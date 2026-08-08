package com.example.profilesettings.feature.profile.impl.presentation.compose

import androidx.compose.runtime.Composable
import androidx.lifecycle.ViewModelStoreOwner
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.profilesettings.feature.profile.api.ProfileDependencies
import com.example.profilesettings.feature.profile.impl.di.ProfileComponent
import com.example.profilesettings.feature.profile.impl.presentation.viewmodel.EditProfileViewModel
import com.example.profilesettings.feature.profile.impl.presentation.viewmodel.EditProfileComponentHolderViewModel
import com.example.profilesettings.feature.profile.impl.presentation.viewmodel.EditProfileComponentHolderViewModelFactory

@Composable
fun EditProfileRoute(
    dependencies: ProfileDependencies,
    viewModelStoreOwner: ViewModelStoreOwner
) {

    val componentHolder: EditProfileComponentHolderViewModel = viewModel(
        viewModelStoreOwner = viewModelStoreOwner,
        factory = EditProfileComponentHolderViewModelFactory(dependencies)
    )

    val component: ProfileComponent = componentHolder.component

    val viewModel: EditProfileViewModel = viewModel(
        viewModelStoreOwner = viewModelStoreOwner,
        factory = component.viewModelFactory()
    )

    EditProfileScreen(viewModel = viewModel)
}