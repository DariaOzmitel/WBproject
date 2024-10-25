package com.example.ui.screen.profile.editProfile

import com.example.ui.model.UserUi

sealed class EditProfileState {
    data class EditProfileContent(
        val user: UserUi
    ) : EditProfileState()

    object Loading : EditProfileState()
}


