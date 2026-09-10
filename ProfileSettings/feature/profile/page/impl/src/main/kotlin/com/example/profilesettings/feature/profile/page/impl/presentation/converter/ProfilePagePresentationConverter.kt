package com.example.profilesettings.feature.profile.page.impl.presentation.converter

import com.example.profilesettings.feature.profile.core.api.domain.ProfileEntity
import com.example.profilesettings.feature.profile.core.api.utils.ProfileUtils
import com.example.profilesettings.feature.profile.page.impl.presentation.model.ProfilePageUi
import javax.inject.Inject

class ProfilePagePresentationConverter @Inject constructor(
    private val utils: ProfileUtils
) {

    fun convertEntityToUi(entity: ProfileEntity): ProfilePageUi {
        return ProfilePageUi(
            photo = utils.getFileFromProfilePhoto(entity.photo),
            name = entity.name,
            email = entity.email,
            title = entity.title,
            location = entity.location
        )
    }
}