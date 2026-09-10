package com.example.profilesettings.feature.profile.settings.impl.presentation.model

sealed interface SettingsProfileAction {

    data object OpenBottomSheet : SettingsProfileAction
}