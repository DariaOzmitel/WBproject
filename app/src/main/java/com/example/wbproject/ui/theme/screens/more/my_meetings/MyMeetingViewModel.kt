package com.example.wbproject.ui.theme.screens.more.my_meetings

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.usecase.GetMeetingListUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

internal class MyMeetingViewModel(private val getMeetingListUseCase: GetMeetingListUseCase) :
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
// TODO()НАДО СДЕЛАТЬ РАЗНЫЕ ЮЗКЕЙСЫ ДЛЯ СПИСКОВ

    private fun getMeetingList() {
        viewModelScope.launch {
            getMeetingListUseCase().collect { meetingList ->
                myMeetingStateMutable.update {
                    MyMeetingState.MyMeetingLists(meetingList, meetingList)
                }
            }
        }
    }
}
