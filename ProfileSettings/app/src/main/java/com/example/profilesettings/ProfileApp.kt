package com.example.profilesettings

import android.app.Application
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import com.example.profilesettings.di.ApplicationComponent
import com.example.profilesettings.di.DaggerApplicationComponent

class ProfileApp : Application() {

    val component: ApplicationComponent by lazy {
        DaggerApplicationComponent.factory().create(this)
    }
}

@Composable
fun getApplicationComponent(): ApplicationComponent =
    (LocalContext.current.applicationContext as ProfileApp).component