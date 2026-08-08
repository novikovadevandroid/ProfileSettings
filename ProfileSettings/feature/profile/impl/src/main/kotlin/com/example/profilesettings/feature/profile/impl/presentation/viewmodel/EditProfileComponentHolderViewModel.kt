package com.example.profilesettings.feature.profile.impl.presentation.viewmodel

import androidx.lifecycle.ViewModel
import com.example.profilesettings.feature.profile.api.ProfileDependencies
import com.example.profilesettings.feature.profile.impl.di.DaggerProfileComponent
import com.example.profilesettings.feature.profile.impl.di.ProfileComponent

class EditProfileComponentHolderViewModel(
    dependencies: ProfileDependencies
) : ViewModel() {

    val component: ProfileComponent = DaggerProfileComponent.factory().create(dependencies)
}