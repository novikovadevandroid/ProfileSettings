package com.example.profilesettings.core.viewmodel.di

import androidx.lifecycle.ViewModelProvider
import com.example.profilesettings.core.viewmodel.ViewModelFactory
import dagger.Binds
import dagger.Module

@Module
interface ViewModelFactoryModule {

    @Binds
    fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}