package ru.dkkovalev.serics.shared.di

import org.kodein.di.DI
import org.kodein.di.bind
import org.kodein.di.instance
import org.kodein.di.provider
import ru.dkkovalev.serics.shared.data.repos.auth.AuthRepo
import ru.dkkovalev.serics.shared.data.repos.auth.AuthRepoImpl
import ru.dkkovalev.serics.shared.domain.auth.*

val authModule = DI.Module("Auth") {
    bind<AuthRepo>() with provider { AuthRepoImpl(instance(), instance()) }
    bind<RequestTokenUseCase>() with provider { RequestTokenUseCaseImpl(instance()) }
    bind<ValidateTokenUseCase>() with provider { ValidateTokenUseCaseImpl(instance()) }
    bind<CreateSessionUseCase>() with provider { CreateSessionUseCaseImpl(instance()) }
}