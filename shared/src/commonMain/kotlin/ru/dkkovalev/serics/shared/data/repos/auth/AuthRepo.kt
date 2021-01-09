package ru.dkkovalev.serics.shared.data.repos.auth

interface AuthRepo {
    suspend fun getRequestToken(): String
    suspend fun getSessionId(): String
}