package com.example.domain.usecase.interfaces

import com.example.domain.model.Meeting
import kotlinx.coroutines.flow.Flow

interface IGetMeetingUseCase {
    operator fun invoke(meetingId: Int): Flow<Meeting>
}