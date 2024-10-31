package com.example.ui

import androidx.annotation.DrawableRes

internal enum class DropdownMenuItems(
    @DrawableRes val imageResId: Int,
    val countryCode: String
) {
    RUSSIA(R.drawable.russian_flag, "+7"),
    SOUTH_KOREA(R.drawable.south_korea_flag, "+82")
}
