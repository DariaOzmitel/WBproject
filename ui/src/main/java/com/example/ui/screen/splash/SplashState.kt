package com.example.ui.screen.splash

internal sealed class SplashState {
    data class AuthorizationStatus(
        val authorizationStatus: Boolean,
    ) : SplashState()

    object Loading : SplashState()
}


