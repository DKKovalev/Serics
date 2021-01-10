package ru.dkkovalev.serics.shared.domain.auth

interface ValidateTokenUseCase {
   suspend fun validateToken(username: String, password: String): String
}