package com.example.profilesettings.di

import android.content.Context
import com.example.profilesettings.feature.profile.api.ProfileDao
import com.example.profilesettings.feature.profile.api.ProfileDependencies
import dagger.BindsInstance
import dagger.Component

@Component(modules = [AppModule::class])
@ApplicationScope
interface ApplicationComponent : ProfileDependencies {

    override fun applicationContext(): Context

    override fun profileDao(): ProfileDao

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): ApplicationComponent
    }
}