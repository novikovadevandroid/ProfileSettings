package com.example.profilesettings.feature.profile.impl.data.converter

import com.example.profilesettings.feature.profile.impl.domain.model.ProfileEntity
import com.example.profilesettings.feature.profile.api.ProfileDbModel


fun ProfileDbModel.toEntity() = ProfileEntity(
    id = this.id,
    photo = photo,
    name = this.name,
    email = this.email,
    title = this.title,
    location = this.location
)

fun ProfileEntity.toDbModel() = ProfileDbModel(
    id = this.id,
    photo = this.photo,
    name = this.name,
    email = this.email,
    title = this.title,
    location = this.location
)