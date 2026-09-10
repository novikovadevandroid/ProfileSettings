package com.example.profilesettings.feature.profile.settings.impl.domain.usecase

interface DeleteSettingsProfilePhotoUseCase {
    suspend operator fun invoke(path: String?)
}