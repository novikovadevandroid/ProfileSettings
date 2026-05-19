package com.example.profilesettings.data.repository

import com.example.profilesettings.data.converter.toDbModel
import com.example.profilesettings.data.converter.toEntity
import com.example.profilesettings.data.local.ProfileDao
import com.example.profilesettings.domain.ProfileRepository
import com.example.profilesettings.models.domain.ProfileEntity
import javax.inject.Inject

class ProfileRepositoryImpl @Inject constructor(
    private val dao: ProfileDao
) : ProfileRepository {
    override suspend fun saveProfile(profile: ProfileEntity) {
        dao.saveProfile(profile.toDbModel())
    }

    override suspend fun getProfile(): ProfileEntity? {
        return dao.getProfile()?.toEntity()
    }

    override suspend fun updateProfile(
        id: Int,
        name: String,
        email: String,
        title: String,
        location: String
    ) {
        dao.updateProfile(id, name, email, title, location)
    }
}