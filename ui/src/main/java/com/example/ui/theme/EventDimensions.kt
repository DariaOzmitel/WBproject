package com.example.ui.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.times

const val scale = 1.2

@Immutable
data class EventDimensions(
    val dimension1: Dp,
    val dimension2: Dp,
    val dimension4: Dp,
    val dimension6: Dp,
    val dimension8: Dp,
    val dimension10: Dp,
    val dimension12: Dp,
    val dimension14: Dp,
    val dimension16: Dp,
    val dimension20: Dp,
    val dimension22: Dp,
    val dimension24: Dp,
    val dimension26: Dp,
    val dimension28: Dp,
    val dimension30: Dp,
    val dimension32: Dp,
    val dimension36: Dp,
    val dimension38: Dp,
    val dimension40: Dp,
    val dimension44: Dp,
    val dimension48: Dp,
    val dimension50: Dp,
    val dimension52: Dp,
    val dimension56: Dp,
    val dimension58: Dp,
    val dimension66: Dp,
    val dimension68: Dp,
    val dimension70: Dp,
    val dimension72: Dp,
    val dimension76: Dp,
    val dimension80: Dp,
    val dimension88: Dp,
    val dimension100: Dp,
    val dimension104: Dp,
    val dimension106: Dp,
    val dimension126: Dp,
    val dimension128: Dp,
    val dimension136: Dp,
    val dimension148: Dp,
    val dimension150: Dp,
    val dimension168: Dp,
    val dimension176: Dp,
    val dimension180: Dp,
    val dimension200: Dp,
    val dimension212: Dp,
    val dimension268: Dp,
    val dimension320: Dp,
    val dimension374: Dp,
)

val EventDimensionsValue = EventDimensions(
    dimension1 = scale * 1.dp,
    dimension2 = scale * 2.dp,
    dimension4 = scale * 4.dp,
    dimension6 = scale * 6.dp,
    dimension8 = scale * 8.dp,
    dimension10 = scale * 10.dp,
    dimension12 = scale * 12.dp,
    dimension14 = scale * 14.dp,
    dimension16 = scale * 16.dp,
    dimension20 = scale * 20.dp,
    dimension22 = scale * 22.dp,
    dimension24 = scale * 24.dp,
    dimension26 = scale * 26.dp,
    dimension28 = scale * 28.dp,
    dimension30 = scale * 30.dp,
    dimension32 = scale * 32.dp,
    dimension36 = scale * 36.dp,
    dimension38 = scale * 38.dp,
    dimension40 = scale * 40.dp,
    dimension44 = scale * 44.dp,
    dimension48 = scale * 48.dp,
    dimension50 = scale * 50.dp,
    dimension52 = scale * 52.dp,
    dimension56 = scale * 56.dp,
    dimension58 = scale * 58.dp,
    dimension66 = scale * 66.dp,
    dimension68 = scale * 68.dp,
    dimension70 = scale * 70.dp,
    dimension72 = scale * 72.dp,
    dimension76 = scale * 76.dp,
    dimension80 = scale * 80.dp,
    dimension88 = scale * 88.dp,
    dimension100 = scale * 100.dp,
    dimension104 = scale * 104.dp,
    dimension106 = scale * 106.dp,
    dimension126 = scale * 126.dp,
    dimension128 = scale * 128.dp,
    dimension136 = scale * 136.dp,
    dimension148 = scale * 148.dp,
    dimension150 = scale * 150.dp,
    dimension168 = scale * 168.dp,
    dimension176 = scale * 176.dp,
    dimension180 = scale * 180.dp,
    dimension200 = scale * 200.dp,
    dimension212 = scale * 212.dp,
    dimension268 = scale * 268.dp,
    dimension320 = scale * 320.dp,
    dimension374 = scale * 374.dp,
)

internal val LocalDimensions = staticCompositionLocalOf { EventDimensionsValue }
