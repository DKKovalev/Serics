package ru.dkkovalev.serics.androidApp.presentation.auth

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import ru.dkkovalev.serics.shared.domain.auth.CreateSessionUseCase
import ru.dkkovalev.serics.shared.domain.auth.RequestTokenUseCase
import ru.dkkovalev.serics.shared.domain.auth.ValidateTokenUseCase

class AuthViewModel(
    private val requestTokenUseCase: RequestTokenUseCase,
    private val validateTokenUseCase: ValidateTokenUseCase,
    private val createSessionUseCase: CreateSessionUseCase
) : ViewModel() {

    val authLiveData: LiveData<AuthState> get() = internalLiveData
    private val internalLiveData: MutableLiveData<AuthState> = MutableLiveData()

    val errorLiveData: LiveData<String> get() = internalErrorLiveData
    private val internalErrorLiveData: MutableLiveData<String> = MutableLiveData()

    fun authorize(login: String, password: String) {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                try {
                    requestTokenUseCase.getToken()
                    validateTokenUseCase.validateToken(login, password)
                    if (createSessionUseCase.createSession().isNotEmpty()) {
                        internalLiveData.postValue(AuthState.Success)
                    } else {
                        internalLiveData.postValue(AuthState.Error(""))
                    }
                } catch (e: Exception) {
                    e.printStackTrace()
                    internalErrorLiveData.postValue(e.message)
                }
            }
        }
    }

}