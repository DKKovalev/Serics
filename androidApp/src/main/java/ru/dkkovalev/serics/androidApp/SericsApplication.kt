package ru.dkkovalev.serics.androidApp

import android.app.Application
import com.github.aakira.napier.DebugAntilog
import com.github.aakira.napier.Napier

class SericsApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        if (BuildConfig.DEBUG) {
            Napier.base(DebugAntilog())
        }
    }
}