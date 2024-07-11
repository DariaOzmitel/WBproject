package com.example.wbproject.ui.theme.domain

import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.wbproject.ui.theme.LightColors

data class MyChipArguments(
    val modifier: Modifier = Modifier,
    val text: String,
    val containerColor: Color = LightColors.brandColorBackGround,
    val contentColor: Color = LightColors.brandColorDark,
)
