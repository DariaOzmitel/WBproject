package com.example.domain.usecase.meeting

import com.example.domain.model.User
import com.example.domain.repository.MeetingRepository
import com.example.domain.usecase.interfaces.IChangeAttendingStatusUseCase

internal class ChangeAttendingStatusUseCase(
    private val repository: MeetingRepository
) : IChangeAttendingStatusUseCase {
    override suspend operator fun invoke(meetingId: Int, user: User) {
        return repository.changeAttendingStatus(meetingId, user)
    }
}