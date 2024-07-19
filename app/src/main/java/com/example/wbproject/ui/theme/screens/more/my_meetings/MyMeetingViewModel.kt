package com.example.wbproject.ui.theme.screens.more.my_meetings

import androidx.lifecycle.ViewModel
import com.example.wbproject.data.mockData.mockListMeetingAlreadyPassed
import com.example.wbproject.data.mockData.mockListMeetings
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class MyMeetingViewModel : ViewModel() {
    private val myMeetingStateMutable = MutableStateFlow(
        MyMeetingState(
            meetingListPlanned = mockListMeetings,
            meetingListAlreadyPassed = mockListMeetingAlreadyPassed
        )
    )
    private val myMeetingState: StateFlow<MyMeetingState> = myMeetingStateMutable

    fun getMyMeetingFlow(): StateFlow<MyMeetingState> = myMeetingState
}
