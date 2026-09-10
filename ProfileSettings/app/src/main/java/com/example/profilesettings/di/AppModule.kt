package com.example.profilesettings.di

import android.content.Context
import com.example.profilesettings.core.database.AppDatabase
import com.example.profilesettings.core.database.ProfileDao
import dagger.Module
import dagger.Provides

@Module
internal interface AppModule {

    companion object {
        @Provides
        @ApplicationScope
        fun provideProfileDao(context: Context): ProfileDao {
            return AppDatabase.getInstance(context).profilePageDao()
        }
    }
}