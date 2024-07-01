package com.example.wbproject.ui.theme.arguments

import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.wbproject.ui.theme.LightColors

data class MyChipArguments(
    val modifier: Modifier = Modifier,
    val myTextArguments: MyTextArguments,
    val containerColor: Color = LightColors.brandColorBackGround,
)
