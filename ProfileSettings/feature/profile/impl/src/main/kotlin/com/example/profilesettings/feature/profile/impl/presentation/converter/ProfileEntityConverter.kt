package com.example.profilesettings.feature.profile.impl.presentation.converter

import com.example.profilesettings.feature.profile.impl.domain.model.ProfileEntity
import com.example.profilesettings.feature.profile.impl.presentation.model.ProfileUi

fun ProfileEntity.toUi() = ProfileUi(
    photo = this.photo,
    name = this.name,
    email = this.email,
    title = this.title,
    location = this.location
)

fun ProfileUi.toEntity() = ProfileEntity(
    photo = this.photo,
    name = this.name,
    email = this.email,
    title = this.title,
    location = this.location
)