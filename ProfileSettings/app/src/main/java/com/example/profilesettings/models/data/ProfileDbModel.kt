package com.example.profilesettings.models.data

import androidx.room.Entity
import androidx.room.PrimaryKey

private const val TABLE_NAME = "profile"

@Entity(tableName = TABLE_NAME)
data class ProfileDbModel(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val name: String,
    val email: String,
    val title: String,
    val location: String
)