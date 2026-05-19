package com.example.profilesettings.presentation.di

import androidx.lifecycle.ViewModel
import com.example.profilesettings.presentation.EditProfileViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface PresentationModule {

    @IntoMap
    @ViewModelKey(EditProfileViewModel::class)
    @Binds
    fun bindEditProfileViewModel(impl: EditProfileViewModel): ViewModel
}