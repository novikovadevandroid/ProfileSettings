package com.example.profilesettings.feature.profile.impl.domain.usecase

import com.example.profilesettings.feature.profile.impl.domain.model.ProfileEntity

interface SaveProfileUseCase{
    suspend operator fun invoke(profile: ProfileEntity)
}