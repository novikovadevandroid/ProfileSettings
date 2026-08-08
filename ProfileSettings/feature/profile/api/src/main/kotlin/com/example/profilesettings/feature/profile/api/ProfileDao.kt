package com.example.profilesettings.feature.profile.api

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow

@Dao
interface ProfileDao {

    @Upsert
    suspend fun saveProfile(profileDbModel: ProfileDbModel)

    @Query("SELECT * FROM profile LIMIT 1")
    fun getProfile(): Flow<ProfileDbModel?>
}