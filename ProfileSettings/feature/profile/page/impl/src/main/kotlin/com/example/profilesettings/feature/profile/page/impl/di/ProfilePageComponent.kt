package com.example.profilesettings.feature.profile.page.impl.di

import androidx.lifecycle.ViewModelProvider
import com.example.profilesettings.core.viewmodel.di.ViewModelFactoryModule
import com.example.profilesettings.feature.profile.page.api.ProfilePageDependencies
import dagger.Component

@ProfilePageScope
@Component(
    dependencies = [ProfilePageDependencies::class],
    modules = [
        ProfilePageModule::class,
        ViewModelFactoryModule::class
    ]
)
interface ProfilePageComponent {
    fun viewModelFactory(): ViewModelProvider.Factory

    @Component.Factory
    interface Factory {
        fun create(
            dependencies: ProfilePageDependencies
        ): ProfilePageComponent
    }
}