package com.example.profilesettings.feature.profile.core.api.domain

import kotlinx.coroutines.flow.Flow

interface ProfileRepository {

    fun getProfile(): Flow<ProfileEntity?>
}