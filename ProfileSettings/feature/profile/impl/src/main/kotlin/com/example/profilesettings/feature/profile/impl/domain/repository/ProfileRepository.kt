package com.example.profilesettings.feature.profile.impl.domain.repository

import com.example.profilesettings.feature.profile.impl.domain.model.ProfileEntity
import kotlinx.coroutines.flow.Flow

interface ProfileRepository {

    suspend fun saveProfile(profile: ProfileEntity)

    suspend fun updateProfile(profile: ProfileEntity)

    fun getProfile(): Flow<ProfileEntity?>
}