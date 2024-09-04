package com.example.ui.screen.splash

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.usecase.interfaces.ICheckAuthorizationUseCase
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

internal class SplashScreenViewModel(private val checkAuthorizationUseCase: ICheckAuthorizationUseCase) :
    ViewModel() {
    private val isUserAuthorizedMutable = MutableStateFlow(false)
    private val isUserAuthorized: StateFlow<Boolean> = isUserAuthorizedMutable

    init {
        checkAuthorization()
    }

    fun getStatusFlow(): StateFlow<Boolean> = isUserAuthorized

    private fun checkAuthorization() {
        viewModelScope.launch {
            delay(SPLASH_SCREEN_DURATION)
//            checkAuthorizationUseCase().collect { authorizationStatus ->
//                isUserAuthorizedMutable.update {
//                    authorizationStatus
//                }
//            }
        }
    }

    companion object {
        private const val SPLASH_SCREEN_DURATION = 1000L
    }
}