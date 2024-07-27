package com.example.wbproject.ui.theme.screens.more.my_meetings

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.usecase.interfaces.IGetFinishedMeetingListUseCase
import com.example.domain.usecase.interfaces.IGetMeetingListUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

internal class MyMeetingViewModel(
    private val getMeetingListUseCase: IGetMeetingListUseCase,
    private val getFinishedMeetingListUseCase: IGetFinishedMeetingListUseCase
) :
    ViewModel() {
    private val myMeetingStateMutable: MutableStateFlow<MyMeetingState> = MutableStateFlow(
        MyMeetingState.Loading
    )
    private val myMeetingState: StateFlow<MyMeetingState> = myMeetingStateMutable

    fun getMyMeetingFlow(): StateFlow<MyMeetingState> = myMeetingState

    init {
        viewModelScope.launch {
            getMeetingList()
        }
    }

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
