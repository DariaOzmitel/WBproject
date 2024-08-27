package com.example.wbproject.ui.theme.deprecatedUi.screens.more

import com.example.domain.model.User

sealed class MoreState {
    data class MoreUser(
        val user: User
    ) : MoreState()

    object Loading : MoreState()

}