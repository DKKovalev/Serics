package ru.dkkovalev.serics.shared.di

import org.kodein.di.DI
import org.kodein.di.bind
import org.kodein.di.instance
import org.kodein.di.provider
import ru.dkkovalev.serics.shared.data.repos.auth.AuthRepo
import ru.dkkovalev.serics.shared.data.repos.auth.AuthRepoImpl
import ru.dkkovalev.serics.shared.domain.auth.RequestTokenUseCase
import ru.dkkovalev.serics.shared.domain.auth.RequestTokenUseCaseImpl

val authModule = DI.Module("Auth") {
    bind<AuthRepo>() with provider { AuthRepoImpl(instance(), instance()) }
    bind<RequestTokenUseCase>() with provider { RequestTokenUseCaseImpl(instance()) }
}