package com.example.profilesettings.feature.profile.page.api

import android.content.Context
import com.example.profilesettings.feature.profile.core.api.domain.GetProfileUseCase
import com.example.profilesettings.feature.profile.core.api.utils.ProfileUtils

interface ProfilePageDependencies {

    fun applicationContext(): Context

    fun getProfileUseCase(): GetProfileUseCase

    fun getProfileUtils(): ProfileUtils
}