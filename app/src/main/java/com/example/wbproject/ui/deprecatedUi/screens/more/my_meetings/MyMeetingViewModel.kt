package com.example.wbproject.ui.theme.deprecatedUi.screens.more.my_meetings

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.usecase.interfaces.IGetEventListUseCase
import com.example.domain.usecase.interfaces.IGetFinishedMeetingListUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

internal class MyMeetingViewModel(
    private val getMeetingListUseCase: IGetEventListUseCase,
    private val getFinishedMeetingListUseCase: IGetFinishedMeetingListUseCase
) :
    ViewModel() {
    private val myMeetingStateMutable: MutableStateFlow<MyMeetingState> = MutableStateFlow(
        MyMeetingState.Loading
    )
    private val myMeetingState: StateFlow<MyMeetingState> = myMeetingStateMutable

    init {
        viewModelScope.launch {
            getMeetingList()
        }
    }

    fun getMyMeetingFlow(): StateFlow<MyMeetingState> = myMeetingState

    private fun getMeetingList() {
        viewModelScope.launch {
            getMeetingListUseCase().collect { meetingList ->
                getFinishedMeetingListUseCase().collect { finishedMeeting ->
                    myMeetingStateMutable.update {
                        MyMeetingState.MyMeetingLists(meetingList, finishedMeeting)
                    }
                }
            }
        }
    }
}
