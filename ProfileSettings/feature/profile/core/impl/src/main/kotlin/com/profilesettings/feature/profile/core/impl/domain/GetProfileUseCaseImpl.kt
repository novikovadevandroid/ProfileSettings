package com.profilesettings.feature.profile.core.impl.domain

import com.example.profilesettings.feature.profile.core.api.domain.GetProfileUseCase
import com.example.profilesettings.feature.profile.core.api.domain.ProfileEntity
import com.example.profilesettings.feature.profile.core.api.domain.ProfileRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetProfileUseCaseImpl @Inject constructor(
    private val repository: ProfileRepository
) : GetProfileUseCase {
    override operator fun invoke(): Flow<ProfileEntity?> = repository.getProfile()
}