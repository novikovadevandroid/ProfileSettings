package com.example.profilesettings.feature.profile.impl.domain.usecase

import com.example.profilesettings.feature.profile.impl.domain.model.ProfileEntity
import com.example.profilesettings.feature.profile.impl.domain.usecase.GetProfileUseCase
import com.example.profilesettings.feature.profile.impl.domain.repository.ProfileRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetProfileUseCaseImpl @Inject constructor(
    private val repository: ProfileRepository
) : GetProfileUseCase {
    override operator fun invoke(): Flow<ProfileEntity?> = repository.getProfile()
}