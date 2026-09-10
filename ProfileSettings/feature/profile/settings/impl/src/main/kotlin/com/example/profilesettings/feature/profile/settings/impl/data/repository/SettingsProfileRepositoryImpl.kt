package com.example.profilesettings.feature.profile.settings.impl.data.repository

import com.example.profilesettings.core.database.ProfileDao
import com.example.profilesettings.feature.profile.core.api.data.ProfileDataConverter
import com.example.profilesettings.feature.profile.core.api.domain.ProfileEntity
import com.example.profilesettings.feature.profile.settings.impl.domain.repository.SettingsProfileRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class SettingsProfileRepositoryImpl @Inject constructor(
    private val dao: ProfileDao,
    private val converter: ProfileDataConverter
) : SettingsProfileRepository {

    override suspend fun saveProfile(profile: ProfileEntity) {
        withContext(Dispatchers.IO) {
            dao.saveProfile(converter.convertEntityToDbModel(profile))
        }
    }

    override suspend fun updateProfile(profile: ProfileEntity) {
        withContext(Dispatchers.IO) {
            dao.saveProfile(converter.convertEntityToDbModel(profile))
        }
    }
}