package com.example.profilesettings.domain

import com.example.profilesettings.models.domain.ProfileEntity

interface ProfileRepository {

    suspend fun saveProfile(profile: ProfileEntity)

    suspend fun getProfile(): ProfileEntity?

    suspend fun updateProfile(
        id: Int,
        name: String,
        email: String,
        title: String,
        location: String
    )
}