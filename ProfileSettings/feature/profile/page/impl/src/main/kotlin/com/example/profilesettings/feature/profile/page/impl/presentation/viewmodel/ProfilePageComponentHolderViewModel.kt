package com.example.profilesettings.feature.profile.page.impl.presentation.viewmodel

import androidx.lifecycle.ViewModel
import com.example.profilesettings.feature.profile.page.api.ProfilePageDependencies
import com.example.profilesettings.feature.profile.page.impl.di.DaggerProfilePageComponent
import com.example.profilesettings.feature.profile.page.impl.di.ProfilePageComponent

class ProfilePageComponentHolderViewModel(
    dependencies: ProfilePageDependencies
) : ViewModel() {

    val component: ProfilePageComponent = DaggerProfilePageComponent.factory().create(dependencies)
}