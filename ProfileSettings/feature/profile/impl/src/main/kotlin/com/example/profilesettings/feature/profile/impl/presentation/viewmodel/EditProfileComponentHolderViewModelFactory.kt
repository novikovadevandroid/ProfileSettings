package com.example.profilesettings.feature.profile.impl.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.profilesettings.feature.profile.api.ProfileDependencies

class EditProfileComponentHolderViewModelFactory(
    private val dependencies: ProfileDependencies
) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass == EditProfileComponentHolderViewModel::class.java) {
            return EditProfileComponentHolderViewModel(dependencies) as T
        }
        throw RuntimeException("Unknow view model class $modelClass")
    }
}