package com.example.profilesettings.presentation.converter

import com.example.profilesettings.models.domain.ProfileEntity
import com.example.profilesettings.models.presentation.ProfileUi

fun ProfileEntity.toUi() = ProfileUi(
    id = this.id,
    name = this.name,
    email = this.email,
    title = this.title,
    location = this.location
)

fun ProfileUi.toEntity() = ProfileEntity(
    id = this.id,
    name = this.name,
    email = this.email,
    title = this.title,
    location = this.title
)