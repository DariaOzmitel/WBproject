package com.example.domain.usecase

import com.example.domain.MeetingRepository
import com.example.domain.model.Meeting
import kotlinx.coroutines.flow.Flow

class GetMeetingUseCase(
    private val repository: MeetingRepository
) {
    operator fun invoke(meetingId: Int): Flow<Meeting> {
        return repository.getMeetingFlow(meetingId)
    }
}