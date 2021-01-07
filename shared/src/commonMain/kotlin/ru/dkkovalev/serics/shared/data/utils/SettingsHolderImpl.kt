package ru.dkkovalev.serics.shared.data.utils

import com.russhwolf.settings.Settings
import com.russhwolf.settings.set

class SettingsHolderImpl(private val settings: Settings) : SettingsHolder {

    companion object {
        private const val KEY_REQUEST_TOKEN = "request_token"
    }

    override fun saveRequestToken(token: String) = settings.set(KEY_REQUEST_TOKEN, token)

    override fun getRequestToken(): String? = settings.getStringOrNull(KEY_REQUEST_TOKEN)
}