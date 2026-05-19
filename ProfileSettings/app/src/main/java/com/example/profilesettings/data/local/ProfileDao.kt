package com.example.profilesettings.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.profilesettings.models.data.ProfileDbModel

@Dao
interface ProfileDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveProfile(profileDbModel: ProfileDbModel)

    @Query("SELECT * FROM profile LIMIT 1")
    suspend fun getProfile(): ProfileDbModel?

    @Query(
        """
        UPDATE profile
        SET name = :name, email = :email, title = :title, location = :location
        WHERE id = :id
    """
    )
    suspend fun updateProfile(
        id: Int,
        name: String,
        email: String,
        title: String,
        location: String,
    )
}