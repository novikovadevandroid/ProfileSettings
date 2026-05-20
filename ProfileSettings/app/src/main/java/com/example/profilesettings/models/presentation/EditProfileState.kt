package com.example.profilesettings.models.presentation

sealed interface EditProfileState {

    data object Initial : EditProfileState

    data object Loading : EditProfileState

    data class Success(val profileUi: ProfileUi?) : EditProfileState

    data class Error(val message: String) : EditProfileState
}