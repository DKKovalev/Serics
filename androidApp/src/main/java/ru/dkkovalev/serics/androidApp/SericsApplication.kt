package ru.dkkovalev.serics.androidApp

import android.app.Application
import com.github.aakira.napier.DebugAntilog
import com.github.aakira.napier.Napier
import org.kodein.di.DI
import org.kodein.di.DIAware
import org.kodein.di.android.x.androidXModule
import org.kodein.di.instance
import ru.dkkovalev.serics.shared.data.utils.SettingsHolder
import ru.dkkovalev.serics.shared.di.kodein.appModule
import ru.dkkovalev.serics.shared.di.kodein.authModule
import ru.dkkovalev.serics.shared.di.kodein.moviesModule
import ru.dkkovalev.serics.shared.di.kodein.popularModule
import java.util.*

class SericsApplication : Application(), DIAware {

    override val di: DI by DI.lazy {
        import(androidXModule(this@SericsApplication))
        importAll(appModule, uiModule, authModule, moviesModule, popularModule, viewModelModule)
    }

    private val settingsHolder by di.instance<SettingsHolder>()

    override fun onCreate() {
        super.onCreate()

        if (BuildConfig.DEBUG) {
            Napier.base(DebugAntilog())
        }

        if (settingsHolder.getLocale() == null) {
            val locale = Locale.getDefault().toLanguageTag()
            settingsHolder.setLocale(locale)
        }
    }
}