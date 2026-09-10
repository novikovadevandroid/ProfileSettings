package com.profilesettings.feature.profile.core.impl.di

import com.example.profilesettings.feature.profile.core.api.data.ProfileDataConverter
import com.example.profilesettings.feature.profile.core.api.domain.GetProfileUseCase
import com.example.profilesettings.feature.profile.core.api.domain.ProfileRepository
import com.example.profilesettings.feature.profile.core.api.utils.ProfileUtils
import com.profilesettings.feature.profile.core.impl.data.ProfileDataConverterImpl
import com.profilesettings.feature.profile.core.impl.data.ProfileRepositoryImpl
import com.profilesettings.feature.profile.core.impl.domain.GetProfileUseCaseImpl
import com.profilesettings.feature.profile.core.impl.utils.ProfileUtilsImpl
import dagger.Binds
import dagger.Module

@Module
interface ProfileModule {

    @Binds
    fun bindProfileRepository(impl: ProfileRepositoryImpl): ProfileRepository

    @Binds
    fun bindGetProfileUseCase(impl: GetProfileUseCaseImpl): GetProfileUseCase

    @Binds
    fun bindProfileUtils(impl: ProfileUtilsImpl): ProfileUtils

    @Binds
    fun bindProfileDataConverter(impl: ProfileDataConverterImpl): ProfileDataConverter
}