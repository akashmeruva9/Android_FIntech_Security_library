package com.androidarmour.android_fintech_security_library

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

/**
 * Created by dilpreet on 19/01/18.
 */

@HiltAndroidApp
class AndroidArmourApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        //need to initialize this
    }
}