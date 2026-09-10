package com.example.profilesettings.feature.profile.settings.impl.domain.repository

import com.example.profilesettings.feature.profile.core.api.domain.ProfileEntity

interface SettingsProfileRepository {

    suspend fun saveProfile(profile: ProfileEntity)

    suspend fun updateProfile(profile: ProfileEntity)
}