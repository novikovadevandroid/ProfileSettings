package com.example.profilesettings.di

import android.content.Context
import com.example.profilesettings.feature.profile.core.api.data.ProfileDataConverter
import com.example.profilesettings.feature.profile.core.api.domain.GetProfileUseCase
import com.example.profilesettings.feature.profile.core.api.utils.ProfileUtils
import com.example.profilesettings.feature.profile.page.api.ProfilePageDependencies
import com.example.profilesettings.feature.profile.settings.api.SettingsProfileDependencies
import com.profilesettings.feature.profile.core.impl.di.ProfileModule
import dagger.BindsInstance
import dagger.Component

@Component(
    modules = [
        AppModule::class,
        ProfileModule::class
    ]
)
@ApplicationScope
interface ApplicationComponent : ProfilePageDependencies, SettingsProfileDependencies {

    override fun applicationContext(): Context

    override fun getProfileUseCase(): GetProfileUseCase

    override fun getProfileUtils(): ProfileUtils

    override fun getProfileDataConverter(): ProfileDataConverter

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): ApplicationComponent
    }
}