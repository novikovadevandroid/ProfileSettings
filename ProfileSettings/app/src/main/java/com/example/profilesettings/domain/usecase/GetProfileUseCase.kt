package com.example.profilesettings.domain.usecase

import com.example.profilesettings.domain.repository.ProfileRepository
import com.example.profilesettings.models.domain.ProfileEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetProfileUseCase @Inject constructor(
    private val repository: ProfileRepository
) {
    operator fun invoke(): Flow<ProfileEntity?> = repository.getProfile()
}