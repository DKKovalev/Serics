package ru.dkkovalev.serics.androidApp

import android.app.Application
import com.github.aakira.napier.DebugAntilog
import com.github.aakira.napier.Napier
import org.kodein.di.DI
import org.kodein.di.DIAware
import org.kodein.di.android.x.androidXModule
import ru.dkkovalev.serics.shared.di.appModule
import ru.dkkovalev.serics.shared.di.authModule

class SericsApplication : Application(), DIAware {

    override val di: DI by DI.lazy {
        import(androidXModule(this@SericsApplication))
        importAll(appModule, authModule)
    }

    override fun onCreate() {
        super.onCreate()

        if (BuildConfig.DEBUG) {
            Napier.base(DebugAntilog())
        }
    }
}