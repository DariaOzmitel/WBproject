package com.example.ui.screen.splash

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.usecase.interfaces.ICheckAuthorizationUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

internal class SplashScreenViewModel(private val checkAuthorizationUseCase: ICheckAuthorizationUseCase) :
    ViewModel() {
    private val splashStateMutable: MutableStateFlow<SplashState> =
        MutableStateFlow(SplashState.Loading)
    private val splashState: StateFlow<SplashState> = splashStateMutable

    init {
        checkAuthorization()
    }

    fun getSplashStateFlow(): StateFlow<SplashState> = splashState

    private fun checkAuthorization() {
        viewModelScope.launch {
            checkAuthorizationUseCase().collect { authorizationStatus ->
                splashStateMutable.update {
                    SplashState.AuthorizationStatus(authorizationStatus)
                }
            }
        }
    }
}