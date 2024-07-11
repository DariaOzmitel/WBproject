package com.example.wbproject.navigation

import com.example.wbproject.R

sealed class LoginScreenTopBarItem(
    val screen: Screen,
    val titleResId: Int?,
    val addLeftArrow: Boolean
) {
    data object EnterNumber : LoginScreenTopBarItem(
        screen = Screen.EnterPhone,
        titleResId = null,
        addLeftArrow = false
    )

    data object EnterPin : LoginScreenTopBarItem(
        screen = Screen.EnterPin,
        titleResId = null,
        addLeftArrow = true
    )

    data object AddProfile : LoginScreenTopBarItem(
        screen = Screen.AddProfile,
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