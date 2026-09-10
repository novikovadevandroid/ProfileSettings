package com.example.profilesettings.feature.profile.settings.impl.presentation.model

sealed interface SettingsProfileEffects {

    data class ShowToast(val message: String) : SettingsProfileEffects
}