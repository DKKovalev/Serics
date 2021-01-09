package ru.dkkovalev.serics.shared.domain.auth

import ru.dkkovalev.serics.shared.data.repos.auth.AuthRepo

class RequestTokenUseCaseImpl(private val repo: AuthRepo) : RequestTokenUseCase {
    override suspend fun getToken() = repo.getRequestToken()
}