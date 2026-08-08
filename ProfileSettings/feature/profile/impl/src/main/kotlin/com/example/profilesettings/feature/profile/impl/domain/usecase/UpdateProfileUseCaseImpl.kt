package com.example.profilesettings.feature.profile.impl.domain.usecase

import com.example.profilesettings.feature.profile.impl.domain.repository.ProfileRepository
import com.example.profilesettings.feature.profile.impl.domain.model.ProfileEntity
import javax.inject.Inject

class UpdateProfileUseCaseImpl @Inject constructor(
    private val repository: ProfileRepository
) : UpdateProfileUseCase {
    override suspend operator fun invoke(profile: ProfileEntity) = repository.updateProfile(profile)
}