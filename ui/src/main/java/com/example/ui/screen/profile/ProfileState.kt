package com.example.ui.screen.profile

import com.example.ui.model.UserUi

sealed class ProfileState {
    data class ProfileContent(
        val user: UserUi
    ) : ProfileState()

    object Loading : ProfileState()
}


