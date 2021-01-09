package ru.dkkovalev.serics.shared.domain.auth

import ru.dkkovalev.serics.shared.domain.UseCase

interface RequestTokenUseCase : UseCase {
    suspend fun getToken(): String
}