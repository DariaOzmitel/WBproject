package com.example.wbproject.ui.theme.screens.splash

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieClipSpec
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.example.wbproject.R
import org.koin.androidx.compose.koinViewModel

private const val MAX_FRAME_NUM = 90
private const val ANIMATION_SPEED = 2.0f

@Composable
fun SplashScreen(modifier: Modifier = Modifier, animationEndListener: (Boolean) -> Unit) {
    val viewModel: SplashViewModel = koinViewModel()
    val authorizationStatus by viewModel.getStatusFlow().collectAsStateWithLifecycle()
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(
                Color.White
            )
    ) {
        val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.tiger_splash_screen))
        val logoAnimationState =
            animateLottieCompositionAsState(
                composition = composition,
                speed = ANIMATION_SPEED,
                clipSpec = LottieClipSpec.Frame(max = MAX_FRAME_NUM)
            )
        LottieAnimation(
            composition = composition,
            progress = { logoAnimationState.progress }
        )
        if (logoAnimationState.isAtEnd && logoAnimationState.isPlaying) {
            when (authorizationStatus) {
                true -> animationEndListener(authorizationStatus)
                false -> animationEndListener(authorizationStatus)
            }

        }
    }
}