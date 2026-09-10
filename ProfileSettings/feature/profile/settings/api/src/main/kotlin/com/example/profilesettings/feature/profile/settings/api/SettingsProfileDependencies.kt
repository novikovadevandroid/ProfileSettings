package com.example.profilesettings.feature.profile.settings.api

import android.content.Context
import com.example.profilesettings.feature.profile.core.api.data.ProfileDataConverter
import com.example.profilesettings.feature.profile.core.api.domain.GetProfileUseCase
import com.example.profilesettings.feature.profile.core.api.utils.ProfileUtils

// Предоставляет profile/page модуль
interface SettingsProfileDependencies {

    fun applicationContext(): Context
    fun getProfileUseCase(): GetProfileUseCase

    fun getProfileUtils(): ProfileUtils

    fun getProfileDataConverter(): ProfileDataConverter
}