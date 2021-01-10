package ru.dkkovalev.serics.shared.data.repos.auth

interface AuthRepo {
    suspend fun getRequestToken(): String
    suspend fun requestSessionId(): String
    suspend fun validateToken(username: String, password: String): String

    fun getSessionId(): String?
}