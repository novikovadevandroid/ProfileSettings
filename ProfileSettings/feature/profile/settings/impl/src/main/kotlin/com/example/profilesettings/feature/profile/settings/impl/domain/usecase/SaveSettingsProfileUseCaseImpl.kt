package com.example.profilesettings.feature.profile.settings.impl.domain.usecase

import com.example.profilesettings.feature.profile.core.api.domain.ProfileEntity
import com.example.profilesettings.feature.profile.settings.impl.domain.repository.SettingsProfileRepository
import javax.inject.Inject

class SaveSettingsProfileUseCaseImpl @Inject constructor(
    private val repository: SettingsProfileRepository
) : SaveSettingsProfileUseCase {

    override suspend operator fun invoke(profile: ProfileEntity) = repository.saveProfile(profile)
}