package com.example.profilesettings.feature.profile.impl.di

import androidx.lifecycle.ViewModelProvider
import com.example.profilesettings.core.common.viewmodel.di.ViewModelFactoryModule
import com.example.profilesettings.feature.profile.api.ProfileDependencies
import dagger.Component

@ProfileScope
@Component(
    dependencies = [ProfileDependencies::class],
    modules = [
        ViewModelModule::class,
        ViewModelFactoryModule::class,
        DataModule::class,
        DomainModule::class
    ]
)
interface ProfileComponent {
    fun viewModelFactory(): ViewModelProvider.Factory

    @Component.Factory
    interface Factory {
        fun create(
            dependencies: ProfileDependencies
        ): ProfileComponent
    }
}