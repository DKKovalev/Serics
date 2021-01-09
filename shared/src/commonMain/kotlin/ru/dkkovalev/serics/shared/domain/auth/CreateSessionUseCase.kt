package ru.dkkovalev.serics.shared.domain.auth

import ru.dkkovalev.serics.shared.domain.UseCase

interface CreateSessionUseCase : UseCase {
    fun createSession()
}