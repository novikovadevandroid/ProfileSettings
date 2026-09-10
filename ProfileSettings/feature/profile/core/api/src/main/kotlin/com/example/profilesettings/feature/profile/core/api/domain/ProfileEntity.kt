package com.example.profilesettings.feature.profile.core.api.domain

data class ProfileEntity(
    var id: Int = UNDEFINED_ID,
    val photo: String,
    val name: String,
    val email: String,
    val title: String,
    val location: String
) {
    companion object Companion {
        const val UNDEFINED_ID = 0
    }
}