package com.example.profilesettings.feature.profile.impl.data.repository

import android.net.Uri
import com.example.profilesettings.feature.profile.impl.data.local.storage.ProfilePhotoStorage
import com.example.profilesettings.feature.profile.impl.domain.repository.ProfilePhotoRepository
import javax.inject.Inject

class ProfilePhotoRepositoryImpl @Inject constructor(
    private val storage: ProfilePhotoStorage
) : ProfilePhotoRepository {
    override suspend fun savePhoto(uri: Uri): String = storage.savePhoto(uri)

    override suspend fun deletePhoto(path: String?) = storage.deletePhoto(path)
}