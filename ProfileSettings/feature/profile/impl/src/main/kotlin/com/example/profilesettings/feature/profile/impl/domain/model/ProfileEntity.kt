package com.example.profilesettings.feature.profile.impl.domain.model

data class ProfileEntity(
    var id: Int = UNDEFINED_ID,
    val photo: String?,
    val name: String,
    val email: String,
    val title: String,
    val location: String
) {
    companion object {
        const val UNDEFINED_ID = 0
    }
}