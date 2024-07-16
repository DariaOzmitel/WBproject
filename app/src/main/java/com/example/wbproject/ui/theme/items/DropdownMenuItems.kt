package com.example.wbproject.ui.theme.items

import com.example.wbproject.R

enum class DropdownMenuItems(
    val imageResId: Int,
    val countryCode: String
) {
    RUSSIA(R.drawable.russian_flag, "+7"),
    SOUTH_KOREA(R.drawable.south_korea_flag, "+82")
}
