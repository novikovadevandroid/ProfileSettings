package com.example.profilesettings.data.repository

import com.example.profilesettings.data.converter.toDbModel
import com.example.profilesettings.data.converter.toEntity
import com.example.profilesettings.data.local.ProfileDao
import com.example.profilesettings.domain.repository.ProfileRepository
import com.example.profilesettings.models.domain.ProfileEntity
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

    override fun getProfile(): Flow<ProfileEntity?> {
        return dao.getProfile().map { it?.toEntity() }
    }

    override suspend fun updateProfile(
        id: Int,
        name: String,
        email: String,
        title: String,
        location: String
    ) {
        withContext(Dispatchers.IO) {
            dao.updateProfile(id, name, email, title, location)
        }
    }
}