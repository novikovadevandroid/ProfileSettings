package com.example.profilesettings.models.domain

data class ProfileEntity(
    val id: Int,
    val name: String,
    val email: String,
    val title: String,
    val location: String
)
