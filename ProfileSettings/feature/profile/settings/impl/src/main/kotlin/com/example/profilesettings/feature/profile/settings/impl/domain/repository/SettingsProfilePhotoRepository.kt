package com.example.profilesettings.feature.profile.settings.impl.domain.repository

import android.net.Uri

interface SettingsProfilePhotoRepository {

    suspend fun savePhoto(uri: Uri): String

    suspend fun deletePhoto(path: String?)
}