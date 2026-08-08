package com.example.profilesettings.feature.profile.api

import android.content.Context

interface ProfileDependencies {
    fun applicationContext(): Context
    fun profileDao(): ProfileDao
}