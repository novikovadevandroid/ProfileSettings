package com.example.profilesettings.feature.profile.settings.impl.presentation.converter

import com.example.profilesettings.feature.profile.core.api.domain.ProfileEntity
import com.example.profilesettings.feature.profile.core.api.utils.ProfileUtils
import com.example.profilesettings.feature.profile.settings.impl.presentation.model.SettingsProfileUi
import javax.inject.Inject

class EditProfileUiConverter @Inject constructor(
    private val utils: ProfileUtils
) {

    fun convertToUi(entity: ProfileEntity): SettingsProfileUi =
        SettingsProfileUi(
            photo = utils.getFileFromProfilePhoto(entity.photo),
            name = entity.name,
            email = entity.email,
            title = entity.title,
            location = entity.location
        )

    fun convertToEntity(ui: SettingsProfileUi): ProfileEntity =
        ProfileEntity(
            photo = ui.photo?.path ?: EMPTY_PATH,
            name = ui.name,
            email = ui.email,
            title = ui.title,
            location = ui.location
        )

    companion object {
        private const val EMPTY_PATH = ""
    }
}
