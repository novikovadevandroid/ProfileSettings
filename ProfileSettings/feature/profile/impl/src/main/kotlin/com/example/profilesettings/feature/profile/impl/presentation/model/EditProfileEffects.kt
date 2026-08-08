package com.example.profilesettings.feature.profile.impl.presentation.model

sealed interface EditProfileEffects {

    data class ShowToast(val message: String) : EditProfileEffects
}