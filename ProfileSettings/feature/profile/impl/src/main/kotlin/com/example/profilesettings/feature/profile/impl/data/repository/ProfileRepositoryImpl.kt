package com.example.profilesettings.feature.profile.impl.data.repository


import com.example.profilesettings.feature.profile.impl.domain.model.ProfileEntity
import com.example.profilesettings.feature.profile.impl.data.converter.toDbModel
import com.example.profilesettings.feature.profile.impl.data.converter.toEntity
import com.example.profilesettings.feature.profile.api.ProfileDao
import com.example.profilesettings.feature.profile.impl.domain.repository.ProfileRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext
import javax.inject.Inject

class ProfileRepositoryImpl @Inject constructor(
    private val dao: ProfileDao
) : ProfileRepository {
    override suspend fun saveProfile(profile: ProfileEntity) {
        withContext(Dispatchers.IO) {
            dao.saveProfile(profile.toDbModel())
        }
    }

    override suspend fun updateProfile(profile: ProfileEntity) {
       withContext(Dispatchers.IO) {
           dao.saveProfile(profile.toDbModel())
       }
    }

    override fun getProfile(): Flow<ProfileEntity?> {
        return dao.getProfile().map { it?.toEntity() }
    }
}