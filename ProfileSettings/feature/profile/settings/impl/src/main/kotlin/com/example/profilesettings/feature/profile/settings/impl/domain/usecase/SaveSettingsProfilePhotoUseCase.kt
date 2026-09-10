package com.example.profilesettings.feature.profile.settings.impl.domain.usecase

import android.net.Uri

interface SaveSettingsProfilePhotoUseCase{
    suspend operator fun invoke(uri: Uri): String
}