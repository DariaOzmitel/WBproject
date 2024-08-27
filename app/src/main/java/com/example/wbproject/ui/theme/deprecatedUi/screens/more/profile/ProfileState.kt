package com.example.wbproject.ui.theme.deprecatedUi.screens.more.profile

import com.example.domain.model.User

sealed class ProfileState {
    data class Profile(
        val user: User
    ) : ProfileState()

    object Loading : ProfileState()

}