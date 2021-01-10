package ru.dkkovalev.serics.shared.domain.auth

import ru.dkkovalev.serics.shared.data.repos.auth.AuthRepo

class CreateSessionUseCaseImpl(
    private val repo: AuthRepo
) : CreateSessionUseCase {

    override suspend fun createSession(): String = repo.requestSessionId()

    override fun getSession(): String? = repo.getSessionId()
}