package ru.dkkovalev.serics.shared.data.repos.auth

import ru.dkkovalev.serics.shared.data.api.TmdbApi
import ru.dkkovalev.serics.shared.data.entity.request.SessionRequestDto
import ru.dkkovalev.serics.shared.data.utils.SettingsHolder

class AuthRepoImpl(
    private val api: TmdbApi,
    private val settingsHolder: SettingsHolder
) : AuthRepo {

    override suspend fun getRequestToken(): String = settingsHolder.getRequestToken()
        ?: api.getToken().requestToken
            .also(settingsHolder::saveRequestToken)

    override suspend fun getSessionId(): String {
        val requestToken = settingsHolder.getRequestToken()
            ?: throw IllegalStateException("Request token cannot be null")

        return settingsHolder.getSessionId()
            ?: api.requestNewSession(SessionRequestDto(requestToken)).sessionId
                .also(settingsHolder::saveSessionId)
    }
}