package com.example.profilesettings.di

import android.app.Application
import com.example.profilesettings.data.di.DataModule
import com.example.profilesettings.presentation.viewmodel.ViewModelFactory
import com.example.profilesettings.presentation.di.PresentationModule
import dagger.BindsInstance
import dagger.Component

@Component(modules = [PresentationModule::class, DataModule::class])
@ApplicationScope
interface ApplicationComponent {

    fun getViewModelFactory(): ViewModelFactory

    @Component.Factory
    interface Factory {

        fun create(@BindsInstance context: Application): ApplicationComponent
    }
}