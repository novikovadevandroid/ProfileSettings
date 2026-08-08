package com.example.profilesettings.feature.profile.impl.di

import androidx.lifecycle.ViewModel
import com.example.profilesettings.core.common.viewmodel.di.ViewModelKey
import com.example.profilesettings.feature.profile.impl.presentation.viewmodel.EditProfileViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
internal interface ViewModelModule {

    @IntoMap
    @ViewModelKey(EditProfileViewModel::class)
    @Binds
    fun bindEditProfileViewModel(impl: EditProfileViewModel): ViewModel
}