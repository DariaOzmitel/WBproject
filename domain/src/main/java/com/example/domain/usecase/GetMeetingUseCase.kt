package com.example.domain.usecase

import com.example.domain.MeetingRepository
import com.example.domain.model.Meeting

class GetMeetingUseCase(
    private val repository: MeetingRepository
) {
    operator fun invoke(): Meeting {
        return repository.getMeeting()
    }
}