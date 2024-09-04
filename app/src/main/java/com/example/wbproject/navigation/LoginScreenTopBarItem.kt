package com.example.wbproject.navigation

import com.example.wbproject.R

sealed class LoginScreenTopBarItem(
    val screen: ScreenV1,
    val titleResId: Int?,
    val addLeftArrow: Boolean
) {
    data object EnterNumber : LoginScreenTopBarItem(
        screen = ScreenV1.EnterPhone,
        titleResId = null,
        addLeftArrow = false
    )

    data object EnterPin : LoginScreenTopBarItem(
        screen = ScreenV1.EnterPin,
        titleResId = null,
        addLeftArrow = true
    )

    data object AddProfile : LoginScreenTopBarItem(
        screen = ScreenV1.AddProfile,
        titleResId = R.string.profile,
        addLeftArrow = true
    )

    companion object {
        val items = listOf(
            EnterNumber,
            EnterPin,
            AddProfile
        )
    }
}