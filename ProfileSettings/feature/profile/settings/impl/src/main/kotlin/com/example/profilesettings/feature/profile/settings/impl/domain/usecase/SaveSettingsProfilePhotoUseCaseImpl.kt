package com.example.profilesettings.feature.profile.settings.impl.domain.usecase

import android.net.Uri
import com.example.profilesettings.feature.profile.settings.impl.domain.repository.SettingsProfilePhotoRepository
import javax.inject.Inject

class SaveSettingsProfilePhotoUseCaseImpl @Inject constructor(
    private val repository: SettingsProfilePhotoRepository
) : SaveSettingsProfilePhotoUseCase {
    override suspend operator fun invoke(uri: Uri): String = repository.savePhoto(uri)
}