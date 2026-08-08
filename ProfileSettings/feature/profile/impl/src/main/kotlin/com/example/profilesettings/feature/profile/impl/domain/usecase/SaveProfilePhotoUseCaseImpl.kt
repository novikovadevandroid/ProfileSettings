package com.example.profilesettings.feature.profile.impl.domain.usecase

import android.net.Uri
import com.example.profilesettings.feature.profile.impl.domain.repository.ProfilePhotoRepository
import javax.inject.Inject

class SaveProfilePhotoUseCaseImpl @Inject constructor(
    private val repository: ProfilePhotoRepository
) : SaveProfilePhotoUseCase {
    override suspend operator fun invoke(uri: Uri): String = repository.savePhoto(uri)
}