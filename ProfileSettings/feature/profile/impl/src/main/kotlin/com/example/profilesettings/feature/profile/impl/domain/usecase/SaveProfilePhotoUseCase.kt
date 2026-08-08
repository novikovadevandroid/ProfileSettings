package com.example.profilesettings.feature.profile.impl.domain.usecase

import android.net.Uri

interface SaveProfilePhotoUseCase{
    suspend operator fun invoke(uri: Uri): String
}