package com.example.profilesettings.feature.profile.settings.impl.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.profilesettings.feature.profile.settings.api.SettingsProfileDependencies

class SettingsProfileComponentHolderViewModelFactory(
    private val dependencies: SettingsProfileDependencies
) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass == SettingsProfileComponentHolderViewModel::class.java) {
            return SettingsProfileComponentHolderViewModel(dependencies) as T
        }
        throw RuntimeException("Unknow view model class $modelClass")
    }
}