package com.profilesettings.feature.profile.core.impl.data

import com.example.profilesettings.core.database.ProfileDbModel
import com.example.profilesettings.feature.profile.core.api.data.ProfileDataConverter
import com.example.profilesettings.feature.profile.core.api.domain.ProfileEntity
import javax.inject.Inject

class ProfileDataConverterImpl @Inject constructor(): ProfileDataConverter {

    override fun convertDbModelToEntity(dbModel: ProfileDbModel?): ProfileEntity {
        return if (dbModel == null) {
            getEmptyEntity()
        } else {
            ProfileEntity(
                photo = dbModel.photo ?: EMPTY_PHOTO_PATH,
                name = dbModel.name,
                email = dbModel.email,
                title = dbModel.title,
                location = dbModel.location
            )
        }
    }

    override fun convertEntityToDbModel(entity: ProfileEntity) : ProfileDbModel {
        return ProfileDbModel(
            id = entity.id,
            photo = entity.photo,
            name = entity.name,
            email = entity.email,
            title = entity.title,
            location = entity.location
        )
    }

    private fun getEmptyEntity(): ProfileEntity = ProfileEntity(
        photo = EMPTY_PHOTO_PATH,
        name = EMPTY_NAME,
        email = EMPTY_EMAIL,
        title = EMPTY_TITLE,
        location = EMPTY_LOCATION
    )

    companion object {
        private const val EMPTY_PHOTO_PATH = ""
        private const val EMPTY_NAME = ""
        private const val EMPTY_EMAIL = ""
        private const val EMPTY_TITLE = ""
        private const val EMPTY_LOCATION = ""
    }
}