package com.example.profilesettings.feature.profile.page.impl.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.profilesettings.feature.profile.page.api.ProfilePageDependencies

class ProfilePageComponentHolderViewModelFactory(
    private val dependencies: ProfilePageDependencies
) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass == ProfilePageComponentHolderViewModel::class.java) {
            return ProfilePageComponentHolderViewModel(dependencies) as T
        }
        throw RuntimeException("Unknow view model class $modelClass")
    }
}