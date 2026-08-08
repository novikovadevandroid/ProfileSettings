package com.example.profilesettings.feature.profile.impl.di

import com.example.profilesettings.feature.profile.impl.domain.usecase.GetProfileUseCase
import com.example.profilesettings.feature.profile.impl.domain.usecase.DeleteProfilePhotoUseCase
import com.example.profilesettings.feature.profile.impl.domain.usecase.DeleteProfilePhotoUseCaseImpl
import com.example.profilesettings.feature.profile.impl.domain.usecase.GetProfileUseCaseImpl
import com.example.profilesettings.feature.profile.impl.domain.usecase.SaveProfilePhotoUseCase
import com.example.profilesettings.feature.profile.impl.domain.usecase.SaveProfilePhotoUseCaseImpl
import com.example.profilesettings.feature.profile.impl.domain.usecase.SaveProfileUseCase
import com.example.profilesettings.feature.profile.impl.domain.usecase.SaveProfileUseCaseImpl
import com.example.profilesettings.feature.profile.impl.domain.usecase.UpdateProfileUseCase
import com.example.profilesettings.feature.profile.impl.domain.usecase.UpdateProfileUseCaseImpl
import dagger.Binds
import dagger.Module

@Module
interface DomainModule {

    @Binds
    fun bindDeleteProfilePhotoUseCase(impl: DeleteProfilePhotoUseCaseImpl) : DeleteProfilePhotoUseCase

    @Binds
    fun bindGetProfileUseCase(impl: GetProfileUseCaseImpl) : GetProfileUseCase

    @Binds
    fun bindSaveProfilePhotoUseCase(impl: SaveProfilePhotoUseCaseImpl): SaveProfilePhotoUseCase

    @Binds
    fun bindSaveProfileUseCase(impl: SaveProfileUseCaseImpl): SaveProfileUseCase

    @Binds
    fun bindUpdateProfileUseCase(impl: UpdateProfileUseCaseImpl): UpdateProfileUseCase
}