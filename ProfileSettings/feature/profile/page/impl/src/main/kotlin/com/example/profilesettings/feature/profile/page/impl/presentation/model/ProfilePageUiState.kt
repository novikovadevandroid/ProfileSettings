package com.example.profilesettings.feature.profile.page.impl.presentation.model

sealed interface ProfilePageUiState {

    data object Initial : ProfilePageUiState

    data object Loading : ProfilePageUiState

    data class Success(val profileUi: ProfilePageUi?) : ProfilePageUiState

    data class Error(val message: String) : ProfilePageUiState
}