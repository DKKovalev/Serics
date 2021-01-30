package ru.dkkovalev.serics.androidApp.presentation.auth

sealed class AuthState {
    object Success : AuthState()
    class Error(val message: String) : AuthState()
}
