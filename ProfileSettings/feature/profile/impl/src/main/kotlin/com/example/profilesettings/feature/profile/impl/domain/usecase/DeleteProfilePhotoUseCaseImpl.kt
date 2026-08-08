package com.example.profilesettings.feature.profile.impl.domain.usecase

import com.example.profilesettings.feature.profile.impl.domain.repository.ProfilePhotoRepository
import javax.inject.Inject

class DeleteProfilePhotoUseCaseImpl @Inject constructor(
    private val repository: ProfilePhotoRepository
) : DeleteProfilePhotoUseCase {
    override suspend operator fun invoke(path: String?) = repository.deletePhoto(path)
}