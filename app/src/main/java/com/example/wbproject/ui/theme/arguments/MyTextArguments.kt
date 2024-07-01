package com.example.wbproject.ui.theme.arguments

import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import com.example.wbproject.ui.theme.LightColors

data class MyTextArguments(
    val modifier: Modifier = Modifier,
    val text: String = "The quick brown fox jumps over the lazy dog",
    val textStyle: TextStyle,
    val color: Color = LightColors.neutralActive
)
