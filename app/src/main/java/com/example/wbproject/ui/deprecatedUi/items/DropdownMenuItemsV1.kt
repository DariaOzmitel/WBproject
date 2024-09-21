package com.example.wbproject.ui.deprecatedUi.items

import androidx.annotation.DrawableRes
import com.example.wbproject.R

enum class DropdownMenuItemsV1(
    @DrawableRes val imageResId: Int,
    val countryCode: String
) {
    RUSSIA(R.drawable.russian_flag, "+7"),
    SOUTH_KOREA(R.drawable.south_korea_flag, "+82")
}