package ru.dkkovalev.serics.shared.data.repos.auth

import ru.dkkovalev.serics.shared.data.entity.response.RequestTokenDto
import ru.dkkovalev.serics.shared.data.entity.response.SessionResponseDto

interface AuthRepo {
    suspend fun getRequestToken(): RequestTokenDto
    suspend fun getSessionId(): SessionResponseDto
}