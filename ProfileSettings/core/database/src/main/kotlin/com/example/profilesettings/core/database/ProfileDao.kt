package com.example.profilesettings.core.database

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow

@Dao
interface ProfileDao {

    @Query("SELECT * FROM profile LIMIT 1")
    fun getProfile(): Flow<ProfileDbModel?>

    @Upsert
    suspend fun saveProfile(profileDbModel: ProfileDbModel)
}