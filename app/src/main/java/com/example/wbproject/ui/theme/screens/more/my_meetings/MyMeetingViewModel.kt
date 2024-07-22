package com.example.wbproject.ui.theme.screens.more.my_meetings

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.usecase.GetMeetingListUseCase
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class MyMeetingViewModel(getMeetingListUseCase: GetMeetingListUseCase) : ViewModel() {
    private val myMeetingStateMutable: MutableStateFlow<MyMeetingState> = MutableStateFlow(
        MyMeetingState.Loading
    )
    private val myMeetingState: StateFlow<MyMeetingState> = myMeetingStateMutable

    fun getMyMeetingFlow(): StateFlow<MyMeetingState> = myMeetingState

    init {
        viewModelScope.launch {
            val meetingList = getMeetingListUseCase.invoke()
            delay(500)
            myMeetingStateMutable.update {
                MyMeetingState.MyMeetingLists(
                    meetingListPlanned = meetingList,
                    meetingListAlreadyPassed = meetingList
                )
            }
        }
    }
}
