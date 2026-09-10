package com.profilesettings.feature.profile.core.impl.utils

import com.example.profilesettings.feature.profile.core.api.utils.ProfileUtils
import java.io.File
import javax.inject.Inject

class ProfileUtilsImpl @Inject constructor() : ProfileUtils {

    override fun getFileFromProfilePhoto(photoPath: String): File? = if (photoPath.isNotBlank()) {
        File(photoPath)
    } else {
        null
    }
}