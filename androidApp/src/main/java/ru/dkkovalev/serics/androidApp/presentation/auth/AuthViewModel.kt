package ru.dkkovalev.serics.androidApp.presentation.auth

import androidx.lifecycle.ViewModel
import ru.dkkovalev.serics.shared.domain.auth.CreateSessionUseCase
import ru.dkkovalev.serics.shared.domain.auth.RequestTokenUseCase

class AuthViewModel(
    private val createSessionUseCase: CreateSessionUseCase,
    private val requestTokenUseCase: RequestTokenUseCase,
    private val validateTokenUseCase: RequestTokenUseCase
) : ViewModel() {

}