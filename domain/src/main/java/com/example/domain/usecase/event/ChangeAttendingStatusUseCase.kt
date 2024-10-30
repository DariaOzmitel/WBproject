package com.example.domain.usecase.event

import com.example.domain.model.User
import com.example.domain.repository.EventsRepository
import com.example.domain.usecase.interfaces.IChangeAttendingStatusUseCase

internal class ChangeAttendingStatusUseCase(
    private val repository: EventsRepository
) : IChangeAttendingStatusUseCase {
    override suspend operator fun invoke(meetingId: Int, user: User) {
        return repository.changeAttendingStatus(meetingId, user)
    }
}