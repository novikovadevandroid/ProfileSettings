package com.example.profilesettings.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.profilesettings.models.data.ProfileDbModel
import kotlinx.coroutines.flow.Flow

@Dao
interface ProfileDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveProfile(profileDbModel: ProfileDbModel)

    @Query("SELECT * FROM profile LIMIT 1")
    fun getProfile(): Flow<ProfileDbModel?>

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