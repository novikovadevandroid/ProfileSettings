package com.example.profilesettings.feature.profile.page.impl.presentation.model

import java.io.File

data class ProfilePageUi(
    val photo: File?,
    val name: String,
    val email: String,
    val title: String,
    val location: String
)
