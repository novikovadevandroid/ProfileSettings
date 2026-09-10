package com.example.profilesettings.feature.profile.settings.impl.domain.usecase

import com.example.profilesettings.feature.profile.settings.impl.domain.repository.SettingsProfilePhotoRepository
import javax.inject.Inject

class DeleteSettingsProfilePhotoUseCaseImpl @Inject constructor(
    private val repository: SettingsProfilePhotoRepository
) : DeleteSettingsProfilePhotoUseCase {
    override suspend operator fun invoke(path: String?) = repository.deletePhoto(path)
}