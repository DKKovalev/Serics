package ru.dkkovalev.serics.shared.domain.auth

interface RequestTokenUseCase {
    suspend fun getToken(): String
}