package ru.dkkovalev.serics.shared.data.repos.auth

import ru.dkkovalev.serics.shared.data.api.TmdbApi
import ru.dkkovalev.serics.shared.data.entity.request.SessionRequestDto
import ru.dkkovalev.serics.shared.data.entity.response.RequestTokenDto
import ru.dkkovalev.serics.shared.data.entity.response.SessionResponseDto
import ru.dkkovalev.serics.shared.data.utils.SettingsHolder

class AuthRepoImpl(
    private val api: TmdbApi,
    private val settingsHolder: SettingsHolder
) : AuthRepo {

    override suspend fun getRequestToken(): RequestTokenDto = api.getToken()
        .also { settingsHolder.saveRequestToken(it.requestToken) }

    override suspend fun getSessionId(): SessionResponseDto {
        val requestToken = settingsHolder.getRequestToken()
            ?: throw IllegalStateException("Request token cannot be null")

        return api.requestNewSession(SessionRequestDto(requestToken))
            .also { settingsHolder.saveSessionId(it.sessionId) }
    }
}