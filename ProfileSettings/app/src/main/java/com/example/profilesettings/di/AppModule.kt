package com.example.profilesettings.di

import android.content.Context
import com.example.profilesettings.data.local.AppDatabase
import com.example.profilesettings.feature.profile.api.ProfileDao
import com.example.profilesettings.feature.profile.impl.di.ProfileScope
import dagger.Module
import dagger.Provides

@Module
internal interface AppModule {

    companion object {
        @Provides
        @ApplicationScope
        fun provideProfileDao(context: Context): ProfileDao {
            return AppDatabase.getInstance(context).profileDao()
        }
    }
}