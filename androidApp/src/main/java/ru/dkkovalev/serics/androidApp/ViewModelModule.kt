package ru.dkkovalev.serics.androidApp

import org.kodein.di.DI
import org.kodein.di.instance
import org.kodein.di.provider
import ru.dkkovalev.serics.androidApp.presentation.auth.AuthViewModel

val viewModelModule = DI.Module("viewModelModule") {
    bindViewModel<AuthViewModel>() with provider {
        AuthViewModel(instance(), instance(), instance())
    }
}