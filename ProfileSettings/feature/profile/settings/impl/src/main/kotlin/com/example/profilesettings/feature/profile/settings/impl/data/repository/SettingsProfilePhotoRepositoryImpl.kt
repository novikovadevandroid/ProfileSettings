package com.example.profilesettings.feature.profile.settings.impl.data.repository

import android.net.Uri
import com.example.profilesettings.feature.profile.settings.impl.data.local.storage.SettingsProfilePhotoStorage
import com.example.profilesettings.feature.profile.settings.impl.domain.repository.SettingsProfilePhotoRepository
import javax.inject.Inject

class SettingsProfilePhotoRepositoryImpl @Inject constructor(
    private val storage: SettingsProfilePhotoStorage
) : SettingsProfilePhotoRepository {
    override suspend fun savePhoto(uri: Uri): String = storage.savePhoto(uri)

    override suspend fun deletePhoto(path: String?) = storage.deletePhoto(path)
}