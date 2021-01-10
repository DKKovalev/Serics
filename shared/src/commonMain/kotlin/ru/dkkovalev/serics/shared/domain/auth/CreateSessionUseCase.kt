package ru.dkkovalev.serics.shared.domain.auth

interface CreateSessionUseCase {
    suspend fun createSession(): String
    fun getSession(): String?
}