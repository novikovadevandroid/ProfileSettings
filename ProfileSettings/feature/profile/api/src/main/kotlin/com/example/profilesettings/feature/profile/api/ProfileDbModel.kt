package com.example.profilesettings.feature.profile.api

import androidx.room.Entity
import androidx.room.PrimaryKey

private const val TABLE_NAME = "profile"

@Entity(tableName = TABLE_NAME)
data class ProfileDbModel(
    @PrimaryKey
    val id: Int = 0,
    val photo: String?,
    val name: String,
    val email: String,
    val title: String,
    val location: String
)