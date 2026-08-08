package com.example.profilesettings.feature.profile.impl.domain.usecase

import com.example.profilesettings.feature.profile.impl.domain.model.ProfileEntity
import kotlinx.coroutines.flow.Flow

interface GetProfileUseCase {
    operator fun invoke(): Flow<ProfileEntity?>
}