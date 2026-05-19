package com.example.profilesettings.models.presentation

sealed interface EditProfileAction {

    data object OpenBottomSheet : EditProfileAction
}