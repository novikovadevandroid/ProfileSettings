package com.example.profilesettings.feature.profile.core.api.data

import com.example.profilesettings.core.database.ProfileDbModel
import com.example.profilesettings.feature.profile.core.api.domain.ProfileEntity

interface ProfileDataConverter {

    fun convertDbModelToEntity(dbModel: ProfileDbModel?): ProfileEntity

    fun convertEntityToDbModel(entity: ProfileEntity) : ProfileDbModel
}