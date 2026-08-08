package com.example.profilesettings

import android.app.Application
import com.example.profilesettings.di.ApplicationComponent
import com.example.profilesettings.di.DaggerApplicationComponent

class ProfileSettingsApp : Application() {

    val component: ApplicationComponent by lazy {
        DaggerApplicationComponent
            .factory()
            .create(this)
    }
}