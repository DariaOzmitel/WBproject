package com.example.wbproject.ui.theme.screens.meetings

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.usecase.GetMeetingListUseCase
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class MeetingListViewModel(getMeetingListUseCase: GetMeetingListUseCase) : ViewModel() {
    private val meetingListStateMutable: MutableStateFlow<MeetingListState> =
        MutableStateFlow(MeetingListState.Loading)
    private val meetingListState: StateFlow<MeetingListState> = meetingListStateMutable

    fun getMeetingListFlow(): StateFlow<MeetingListState> = meetingListState

    init {
        viewModelScope.launch {
            val communityList = getMeetingListUseCase.invoke()
            delay(500)
            meetingListStateMutable.update { MeetingListState.MeetingList(list = communityList) }
        }
    }
}
