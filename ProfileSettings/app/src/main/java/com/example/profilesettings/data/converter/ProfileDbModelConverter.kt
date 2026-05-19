package com.example.profilesettings.data.converter

import com.example.profilesettings.models.data.ProfileDbModel
import com.example.profilesettings.models.domain.ProfileEntity

fun ProfileDbModel.toEntity() = ProfileEntity(
    id = this.id,
    name = this.name,
    email = this.email,
    title = this.title,
    location = this.location
)

fun ProfileEntity.toDbModel() = ProfileDbModel(
    id = this.id,
    name = this.name,
    email = this.email,
    title = this.title,
    location = this.location
)