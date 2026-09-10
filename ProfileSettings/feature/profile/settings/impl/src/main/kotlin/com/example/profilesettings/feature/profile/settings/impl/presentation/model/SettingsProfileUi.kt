package com.example.profilesettings.feature.profile.settings.impl.presentation.model

import java.io.File

data class SettingsProfileUi(
    val photo: File?,
    val name: String,
    val email: String,
    val title: String,
    val location: String
)
