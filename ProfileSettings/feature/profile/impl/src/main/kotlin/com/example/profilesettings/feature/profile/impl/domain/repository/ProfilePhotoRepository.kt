package com.example.profilesettings.feature.profile.impl.domain.repository

import android.net.Uri

interface ProfilePhotoRepository {

    suspend fun savePhoto(uri: Uri): String

    suspend fun deletePhoto(path: String?)
}