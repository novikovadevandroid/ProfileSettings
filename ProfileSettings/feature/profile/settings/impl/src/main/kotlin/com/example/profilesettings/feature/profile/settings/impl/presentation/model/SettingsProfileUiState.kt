package com.example.profilesettings.feature.profile.settings.impl.presentation.model

sealed interface SettingsProfileUiState {

    data object Initial : SettingsProfileUiState

    data object Loading : SettingsProfileUiState

    data class Success(val profileUi: SettingsProfileUi?) : SettingsProfileUiState

    data class Error(val message: String) : SettingsProfileUiState
}