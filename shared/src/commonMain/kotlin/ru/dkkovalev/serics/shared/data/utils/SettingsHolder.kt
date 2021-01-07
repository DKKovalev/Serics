package ru.dkkovalev.serics.shared.data.utils

interface SettingsHolder {
    fun saveRequestToken(token: String)
    fun getRequestToken(): String?

    fun saveSessionId(sessionId: String)
    fun getSessionId(): String?
}