package com.example.ui.screen.main.people

import com.example.domain.model.User

internal sealed class PeopleState {
    data class PeopleContent(
        val peopleList: List<User>
    ) : PeopleState()

    object Loading : PeopleState()
}


