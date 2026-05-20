package com.example.profilesettings.domain.repository

import com.example.profilesettings.models.domain.ProfileEntity
import kotlinx.coroutines.flow.Flow

interface ProfileRepository {

    suspend fun saveProfile(profile: ProfileEntity)

    fun getProfile(): Flow<ProfileEntity?>

    suspend fun updateProfile(
        id: Int,
        name: String,
        email: String,
        title: String,
        location: String
    )
}