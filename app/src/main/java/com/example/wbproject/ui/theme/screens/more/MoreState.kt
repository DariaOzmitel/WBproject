package com.example.wbproject.ui.theme.screens.more

import com.example.domain.model.User

sealed class MoreState {
    data class MoreUser(
        val user: User
    ) : MoreState()

    object Loading : MoreState()

}