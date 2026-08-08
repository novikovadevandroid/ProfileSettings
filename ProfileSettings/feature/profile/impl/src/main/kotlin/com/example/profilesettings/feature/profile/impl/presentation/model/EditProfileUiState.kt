package com.example.profilesettings.feature.profile.impl.presentation.model

sealed interface EditProfileUiState {

    data object Initial : EditProfileUiState

    data object Loading : EditProfileUiState

    data class Success(val profileUi: ProfileUi?) : EditProfileUiState

    data class Error(val message: String) : EditProfileUiState
}