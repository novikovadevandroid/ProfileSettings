package com.example.profilesettings.feature.profile.core.api.utils

import java.io.File

interface ProfileUtils {

    fun getFileFromProfilePhoto(photoPath: String) : File?
}