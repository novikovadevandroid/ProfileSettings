package com.example.profilesettings.feature.profile.settings.impl.domain.usecase

import com.example.profilesettings.feature.profile.core.api.domain.ProfileEntity

interface SaveSettingsProfileUseCase{
    suspend operator fun invoke(profile: ProfileEntity)
}