package ru.dkkovalev.serics.shared.domain.auth

import ru.dkkovalev.serics.shared.data.repos.auth.AuthRepo

class ValidateTokenUseCaseImpl(private val repo: AuthRepo) : ValidateTokenUseCase {
    override suspend fun validateToken(username: String, password: String): String {
        return repo.validateToken(username, password)
    }
}