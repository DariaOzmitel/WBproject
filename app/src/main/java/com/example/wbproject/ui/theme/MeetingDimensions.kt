package com.example.wbproject.ui.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Immutable
data class MeetingDimensions(
    val dimension1: Dp,
    val dimension2: Dp,
    val dimension4: Dp,
    val dimension8: Dp,
    val dimension12: Dp,
    val dimension16: Dp,
    val dimension20: Dp,
    val dimension22: Dp,
    val dimension24: Dp,
    val dimension32: Dp,
    val dimension40: Dp,
    val dimension48: Dp,
    val dimension56: Dp,
    val dimension70: Dp,
    val dimension72: Dp,
    val dimension80: Dp,
    val dimension100: Dp,
    val dimension128: Dp,
    val dimension150: Dp,
    val dimension200: Dp,
)

val MeetingDimensionsValue = MeetingDimensions(
    dimension1 = 1.dp,
    dimension2 = 2.dp,
    dimension4 = 4.dp,
    dimension8 = 8.dp,
    dimension12 = 12.dp,
    dimension16 = 16.dp,
    dimension20 = 20.dp,
    dimension22 = 22.dp,
    dimension24 = 24.dp,
    dimension32 = 32.dp,
    dimension40 = 40.dp,
    dimension48 = 48.dp,
    dimension56 = 56.dp,
    dimension70 = 70.dp,
    dimension72 = 72.dp,
    dimension80 = 80.dp,
    dimension100 = 100.dp,
    dimension128 = 128.dp,
    dimension150 = 150.dp,
    dimension200 = 200.dp,
)


internal val LocalDimensions = staticCompositionLocalOf { MeetingDimensionsValue }
