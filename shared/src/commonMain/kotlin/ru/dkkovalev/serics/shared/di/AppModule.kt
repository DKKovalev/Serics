@file:Suppress("EXPERIMENTAL_API_USAGE")

package ru.dkkovalev.serics.shared.di

import com.github.aakira.napier.Napier
import com.russhwolf.settings.Settings
import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.client.features.logging.*
import kotlinx.serialization.json.Json
import org.kodein.di.*
import ru.dkkovalev.serics.shared.data.api.TmdbApi
import ru.dkkovalev.serics.shared.data.api.TmdbApiImpl
import ru.dkkovalev.serics.shared.data.utils.SettingsHolder
import ru.dkkovalev.serics.shared.data.utils.SettingsHolderImpl

val appModule = DI.Module("AppModule") {

    bind<Settings>() with singleton { Settings() }

    bind<Json>() with singleton {
        Json {
            ignoreUnknownKeys = true
            isLenient = true
            encodeDefaults = false
        }
    }

    bind<HttpClient>() with singleton {
        HttpClient(CIO) {
            install(Logging) {
                level = LogLevel.ALL
                logger = object : Logger {
                    override fun log(message: String) {
                        Napier.d(tag = "HttpClient", message = message)
                    }
                }
            }

            install(JsonFeature) {
                serializer = KotlinxSerializer(instance())
            }
        }
    }

    bind<SettingsHolder>() with singleton { SettingsHolderImpl(instance()) }

    bind<TmdbApi>() with provider { TmdbApiImpl(instance(), "ru_RU") }
}