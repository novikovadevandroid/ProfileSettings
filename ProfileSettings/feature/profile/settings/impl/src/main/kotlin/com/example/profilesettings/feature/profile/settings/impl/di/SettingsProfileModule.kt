package com.example.profilesettings.feature.profile.settings.impl.di

import android.content.Context
import androidx.lifecycle.ViewModel
import com.example.profilesettings.core.database.AppDatabase
import com.example.profilesettings.core.database.ProfileDao
import com.example.profilesettings.core.viewmodel.di.ViewModelKey
import com.example.profilesettings.feature.profile.settings.impl.data.repository.SettingsProfilePhotoRepositoryImpl
import com.example.profilesettings.feature.profile.settings.impl.data.repository.SettingsProfileRepositoryImpl
import com.example.profilesettings.feature.profile.settings.impl.domain.repository.SettingsProfilePhotoRepository
import com.example.profilesettings.feature.profile.settings.impl.domain.repository.SettingsProfileRepository
import com.example.profilesettings.feature.profile.settings.impl.domain.usecase.DeleteSettingsProfilePhotoUseCase
import com.example.profilesettings.feature.profile.settings.impl.domain.usecase.DeleteSettingsProfilePhotoUseCaseImpl
import com.example.profilesettings.feature.profile.settings.impl.domain.usecase.SaveSettingsProfilePhotoUseCase
import com.example.profilesettings.feature.profile.settings.impl.domain.usecase.SaveSettingsProfilePhotoUseCaseImpl
import com.example.profilesettings.feature.profile.settings.impl.domain.usecase.SaveSettingsProfileUseCase
import com.example.profilesettings.feature.profile.settings.impl.domain.usecase.SaveSettingsProfileUseCaseImpl
import com.example.profilesettings.feature.profile.settings.impl.domain.usecase.UpdateSettingsProfileUseCase
import com.example.profilesettings.feature.profile.settings.impl.domain.usecase.UpdateSettingsProfileUseCaseImpl
import com.example.profilesettings.feature.profile.settings.impl.presentation.viewmodel.SettingsProfileViewModel
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap

@Module
interface SettingsProfileModule {

    @Binds
    fun bindSettingsProfileRepository(impl: SettingsProfileRepositoryImpl): SettingsProfileRepository

    @Binds
    fun bindSettingsProfilePhotoRepository(impl: SettingsProfilePhotoRepositoryImpl): SettingsProfilePhotoRepository

    @Binds
    fun bindDeleteSettingsProfilePhotoUseCase(impl: DeleteSettingsProfilePhotoUseCaseImpl) : DeleteSettingsProfilePhotoUseCase

    @Binds
    fun bindSaveSettingsProfilePhotoUseCase(impl: SaveSettingsProfilePhotoUseCaseImpl): SaveSettingsProfilePhotoUseCase

    @Binds
    fun bindSaveSettingsProfileUseCase(impl: SaveSettingsProfileUseCaseImpl): SaveSettingsProfileUseCase

    @Binds
    fun bindUpdateSettingsProfileUseCase(impl: UpdateSettingsProfileUseCaseImpl): UpdateSettingsProfileUseCase

    @IntoMap
    @ViewModelKey(SettingsProfileViewModel::class)
    @Binds
    fun bindSettingsProfileViewModel(impl: SettingsProfileViewModel): ViewModel

    companion object {
        @Provides
        fun provideProfileDao(context: Context): ProfileDao {
            return AppDatabase.getInstance(context).profilePageDao()
        }
    }
}