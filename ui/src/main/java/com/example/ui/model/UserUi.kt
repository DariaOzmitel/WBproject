package com.example.ui.model

import com.example.data.mockData.mockCommunityList
import com.example.data.mockData.mockInterests
import com.example.data.mockData.mockListEvents
import com.example.domain.model.Community
import com.example.domain.model.Event
import com.example.domain.model.Interest

data class UserUi(
    val avatarModel: Any?,
    val name: String,
    val phone: String,
    val city: String? = null,
    val description: String? = null,
    val interests: List<Interest>? = null,
    val events: List<Event>? = null,
    val communities: List<Community>? = null,
) {
    companion object {
        val mockUserUi = UserUi(
            avatarModel = "https://static.tildacdn.com/tild6434-6465-4334-a666-316238363037/beautiful-shot-of-tw.jpg",
            name = "Иван",
            phone = "+7 999 999-99-99",
            city = "Москва",
            description = "Занимаюсь разрабокой интерфейсов в eCom. Учу HTML, CSS и JavaScript",
            interests = mockInterests,
            events = mockListEvents,
            communities = mockCommunityList
        )
    }
}