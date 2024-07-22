package com.example.domain.usecase

import com.example.domain.MeetingRepository
import com.example.domain.model.Meeting

class GetMeetingListUseCase(
    private val repository: MeetingRepository
) {
    operator fun invoke(): List<Meeting> {
        return repository.getMeetingList()
    }
}