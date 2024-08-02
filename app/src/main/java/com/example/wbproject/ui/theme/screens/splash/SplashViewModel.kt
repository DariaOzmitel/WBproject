package com.example.wbproject.ui.theme.screens.splash

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.usecase.interfaces.ICheckAuthorizationUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

internal class SplashViewModel(private val checkAuthorizationUseCase: ICheckAuthorizationUseCase) :
    ViewModel() {
    private val isUserAuthorizedMutable = MutableStateFlow(false)
    private val isUserAuthorized: StateFlow<Boolean> = isUserAuthorizedMutable


    init {
        checkAuthorization()
    }

    fun getStatusFlow(): StateFlow<Boolean> = isUserAuthorized

    private fun checkAuthorization() {
        viewModelScope.launch {
            checkAuthorizationUseCase().collect { authorizationStatus ->
                isUserAuthorizedMutable.update {
                    authorizationStatus
                }
            }
        }
    }
}