package com.example.wbproject.ui.theme.arguments

import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter

data class MyAvatarArgs(
    val modifier: Modifier = Modifier,
    val painter: Painter,
    val contentDescription: String = "",
)
