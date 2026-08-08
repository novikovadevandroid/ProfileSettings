package com.example.profilesettings.feature.profile.impl.domain.usecase

interface DeleteProfilePhotoUseCase {
    suspend operator fun invoke(path: String?)
}