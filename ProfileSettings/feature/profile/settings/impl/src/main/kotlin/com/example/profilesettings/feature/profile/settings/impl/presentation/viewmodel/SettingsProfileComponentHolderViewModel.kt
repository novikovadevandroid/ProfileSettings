package com.example.profilesettings.feature.profile.settings.impl.presentation.viewmodel

import androidx.lifecycle.ViewModel
import com.example.profilesettings.feature.profile.settings.api.SettingsProfileDependencies
import com.example.profilesettings.feature.profile.settings.impl.di.DaggerSettingsProfileComponent
import com.example.profilesettings.feature.profile.settings.impl.di.SettingsProfileComponent

class SettingsProfileComponentHolderViewModel(
    dependencies: SettingsProfileDependencies
) : ViewModel() {

    val component: SettingsProfileComponent = DaggerSettingsProfileComponent.factory().create(dependencies)
}