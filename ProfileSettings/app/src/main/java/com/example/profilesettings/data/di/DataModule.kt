package com.example.profilesettings.data.di

import android.app.Application
import com.example.profilesettings.data.local.AppDatabase
import com.example.profilesettings.data.local.ProfileDao
import com.example.profilesettings.data.repository.ProfileRepositoryImpl
import com.example.profilesettings.di.ApplicationScope
import com.example.profilesettings.domain.ProfileRepository
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
interface DataModule {

    @Binds
    fun bindProfileRepository(impl: ProfileRepositoryImpl): ProfileRepository

    companion object {
        @Provides
        @ApplicationScope
        fun provideProfileDao(application: Application): ProfileDao {
            return AppDatabase.getInstance(application).profileDao()
        }
    }
}