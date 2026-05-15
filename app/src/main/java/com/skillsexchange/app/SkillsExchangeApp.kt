package com.skillsexchange.app

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class SkillsExchangeApp : Application() {
    override fun onCreate() {
        super.onCreate()
    }
}