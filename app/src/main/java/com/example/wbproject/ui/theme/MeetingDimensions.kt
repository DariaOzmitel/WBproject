package com.example.wbproject.ui.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.times

const val scale = 1.25

@Immutable
data class MeetingDimensions(
    val dimension1: Dp,
    val dimension2: Dp,
    val dimension4: Dp,
    val dimension6: Dp,
    val dimension8: Dp,
    val dimension12: Dp,
    val dimension16: Dp,
    val dimension20: Dp,
    val dimension22: Dp,
    val dimension24: Dp,
    val dimension32: Dp,
    val dimension36: Dp,
    val dimension38: Dp,
    val dimension40: Dp,
    val dimension48: Dp,
    val dimension50: Dp,
    val dimension52: Dp,
    val dimension56: Dp,
    val dimension66: Dp,
    val dimension68: Dp,
    val dimension70: Dp,
    val dimension72: Dp,
    val dimension80: Dp,
    val dimension88: Dp,
    val dimension100: Dp,
    val dimension128: Dp,
    val dimension150: Dp,
    val dimension176: Dp,
    val dimension200: Dp,
)

val MeetingDimensionsValue = MeetingDimensions(
    dimension1 = scale * 1.dp,
    dimension2 = scale * 2.dp,
    dimension4 = scale * 4.dp,
    dimension6 = scale * 6.dp,
    dimension8 = scale * 8.dp,
    dimension12 = scale * 12.dp,
    dimension16 = scale * 16.dp,
    dimension20 = scale * 20.dp,
    dimension22 = scale * 22.dp,
    dimension24 = scale * 24.dp,
    dimension32 = scale * 32.dp,
    dimension36 = scale * 36.dp,
    dimension38 = scale * 38.dp,
    dimension40 = scale * 40.dp,
    dimension48 = scale * 48.dp,
    dimension50 = scale * 50.dp,
    dimension52 = scale * 52.dp,
    dimension56 = scale * 56.dp,
    dimension66 = scale * 66.dp,
    dimension68 = scale * 68.dp,
    dimension70 = scale * 70.dp,
    dimension72 = scale * 72.dp,
    dimension80 = scale * 80.dp,
    dimension88 = scale * 88.dp,
    dimension100 = scale * 100.dp,
    dimension128 = scale * 128.dp,
    dimension150 = scale * 150.dp,
    dimension176 = scale * 176.dp,
    dimension200 = scale * 200.dp,
)


internal val LocalDimensions = staticCompositionLocalOf { MeetingDimensionsValue }
