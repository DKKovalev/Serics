package ru.dkkovalev.serics.shared

import ru.dkkovalev.serics.shared.domain.UseCase

interface UseCaseFactory {
    fun get(): UseCase
}