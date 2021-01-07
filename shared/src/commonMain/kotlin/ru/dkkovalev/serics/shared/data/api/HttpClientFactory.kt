package ru.dkkovalev.serics.shared.data.api

import com.github.aakira.napier.Napier
import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.client.features.logging.*
import kotlinx.serialization.json.Json


@Suppress("EXPERIMENTAL_API_USAGE")
class HttpClientFactory {

    private val json = Json {
        ignoreUnknownKeys = true
        isLenient = true
        encodeDefaults = false
    }

    fun create(enableLogging: Boolean): HttpClient = HttpClient(CIO) {
        if (enableLogging) {
            install(Logging) {
                level = LogLevel.ALL
                logger = object : Logger {
                    override fun log(message: String) {
                        Napier.d(tag = "HttpClient", message = message)
                    }
                }
            }
        }

        install(JsonFeature) {
            serializer = KotlinxSerializer(json)
        }
    }
}