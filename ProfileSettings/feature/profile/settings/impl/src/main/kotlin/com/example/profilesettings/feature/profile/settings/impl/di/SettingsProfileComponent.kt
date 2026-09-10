package com.example.profilesettings.feature.profile.settings.impl.di

import androidx.lifecycle.ViewModelProvider
import com.example.profilesettings.core.viewmodel.di.ViewModelFactoryModule
import com.example.profilesettings.feature.profile.settings.api.SettingsProfileDependencies
import dagger.Component

@SettingsProfileScope
@Component(
    dependencies = [SettingsProfileDependencies::class],
    modules = [
        ViewModelFactoryModule::class,
        SettingsProfileModule::class
    ]
)
interface SettingsProfileComponent {

    fun viewModelFactory(): ViewModelProvider.Factory

    @Component.Factory
    interface Factory {
        fun create(
            dependencies: SettingsProfileDependencies
        ): SettingsProfileComponent
    }
}