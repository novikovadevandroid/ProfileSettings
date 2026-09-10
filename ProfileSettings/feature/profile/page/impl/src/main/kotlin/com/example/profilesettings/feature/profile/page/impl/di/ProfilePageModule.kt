package com.example.profilesettings.feature.profile.page.impl.di

import android.content.Context
import androidx.lifecycle.ViewModel
import com.example.profilesettings.core.database.AppDatabase
import com.example.profilesettings.core.database.ProfileDao
import com.example.profilesettings.core.viewmodel.di.ViewModelKey
import com.example.profilesettings.feature.profile.page.impl.presentation.viewmodel.ProfilePageViewModel
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap

@Module
interface ProfilePageModule {

    @IntoMap
    @ViewModelKey(ProfilePageViewModel::class)
    @Binds
    fun bindSettingsProfileViewModel(impl: ProfilePageViewModel): ViewModel

    companion object {
        @Provides
        fun provideProfileDao(context: Context): ProfileDao {
            return AppDatabase.getInstance(context).profilePageDao()
        }
    }
}