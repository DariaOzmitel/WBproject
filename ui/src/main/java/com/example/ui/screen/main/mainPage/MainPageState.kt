package com.example.ui.screen.main.mainPage

import com.example.domain.model.Community
import com.example.domain.model.Event
import com.example.ui.model.InterestUi

internal sealed class MainPageState {
    data class MainPageDetail(
        val eventList: List<Event>,
        val communityList: List<Community>,
        val interestsList: List<InterestUi>,
        val authorizationStatus: Boolean
    ) : MainPageState()

    object Loading : MainPageState()
}