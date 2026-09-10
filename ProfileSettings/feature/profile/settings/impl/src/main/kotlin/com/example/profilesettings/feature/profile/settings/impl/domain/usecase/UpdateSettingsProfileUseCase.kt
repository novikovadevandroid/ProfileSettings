package com.example.profilesettings.feature.profile.settings.impl.domain.usecase

import com.example.profilesettings.feature.profile.core.api.domain.ProfileEntity

interface UpdateSettingsProfileUseCase {
    suspend operator fun invoke(profile: ProfileEntity)
}