package com.example.profilesettings.feature.profile.impl.presentation.model

sealed interface EditProfileAction {

    data object OpenBottomSheet : EditProfileAction
}