package com.profilesettings.feature.profile.core.impl.data

import com.example.profilesettings.core.database.ProfileDao
import com.example.profilesettings.feature.profile.core.api.domain.ProfileEntity
import com.example.profilesettings.feature.profile.core.api.domain.ProfileRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class ProfileRepositoryImpl @Inject constructor(
    private val dao: ProfileDao,
    private val converter: ProfileDataConverterImpl
) : ProfileRepository {

    override fun getProfile(): Flow<ProfileEntity?> {
        return dao.getProfile().map { converter.convertDbModelToEntity(it) }
    }
}