package com.example.wbproject.ui.theme.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieClipSpec
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.example.wbproject.R

private const val MAX_FRAME_NUM = 90

@Composable
fun SplashScreen(animationEndListener: () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Color.White
            )
    ) {
        val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.tiger_splash_screen))
        val logoAnimationState =
            animateLottieCompositionAsState(
                composition = composition,
                speed = 2.0f,
                clipSpec = LottieClipSpec.Frame(max = MAX_FRAME_NUM)
            )
        LottieAnimation(
            composition = composition,
            progress = { logoAnimationState.progress }
        )
        if (logoAnimationState.isAtEnd && logoAnimationState.isPlaying) {
            animationEndListener()
        }
    }
}