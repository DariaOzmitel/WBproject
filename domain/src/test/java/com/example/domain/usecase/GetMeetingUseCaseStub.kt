package com.example.domain.usecase

import com.example.domain.model.Meeting
import com.example.domain.repository.MeetingRepository
import com.example.domain.usecase.interfaces.IGetMeetingUseCase
import kotlinx.coroutines.flow.Flow

internal class GetMeetingUseCaseStub(
    private val repository: MeetingRepository
) : IGetMeetingUseCase {
    override operator fun invoke(meetingId: Int): Flow<Meeting> {
        return repository.getMeetingFlow(meetingId)
    }
}