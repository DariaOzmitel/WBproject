package com.example.domain.usecase.interfaces

import com.example.domain.model.User

interface IChangeAttendingStatusUseCase {
    suspend operator fun invoke(meetingId: Int, user: User)
}