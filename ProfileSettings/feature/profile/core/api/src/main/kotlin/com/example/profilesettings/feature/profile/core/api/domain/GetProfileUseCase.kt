package com.example.profilesettings.feature.profile.core.api.domain

import kotlinx.coroutines.flow.Flow

interface GetProfileUseCase {
    operator fun invoke(): Flow<ProfileEntity?>
}