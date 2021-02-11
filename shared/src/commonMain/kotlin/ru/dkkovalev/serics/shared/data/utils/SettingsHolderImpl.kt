package ru.dkkovalev.serics.shared.data.utils

import com.russhwolf.settings.Settings
import com.russhwolf.settings.set

class SettingsHolderImpl(private val settings: Settings) : SettingsHolder {

    companion object {
        private const val KEY_REQUEST_TOKEN = "request_token"
        private const val KEY_LOCALE = "locale"
    }

    override fun saveRequestToken(token: String) = settings.set(KEY_REQUEST_TOKEN, token)

    override fun getRequestToken(): String? = settings.getStringOrNull(KEY_REQUEST_TOKEN)
    override fun saveSessionId(sessionId: String) {
    }

    override fun getSessionId(): String? = null

    override fun setLocale(locale: String) = settings.set(KEY_LOCALE, locale)
    override fun getLocale(): String? = settings.getStringOrNull(KEY_LOCALE)
}