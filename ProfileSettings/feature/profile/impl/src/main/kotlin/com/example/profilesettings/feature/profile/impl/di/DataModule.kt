package com.example.profilesettings.feature.profile.impl.di

import com.example.profilesettings.feature.profile.impl.data.repository.ProfilePhotoRepositoryImpl
import com.example.profilesettings.feature.profile.impl.data.repository.ProfileRepositoryImpl
import com.example.profilesettings.feature.profile.impl.domain.repository.ProfilePhotoRepository
import com.example.profilesettings.feature.profile.impl.domain.repository.ProfileRepository
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
interface DataModule {

    @Binds
    fun bindProfileRepository(impl: ProfileRepositoryImpl): ProfileRepository

    @Binds
    fun bindProfilePhotoRepository(impl: ProfilePhotoRepositoryImpl): ProfilePhotoRepository
}