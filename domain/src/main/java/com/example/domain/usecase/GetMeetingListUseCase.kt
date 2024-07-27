package com.example.domain.usecase

import com.example.domain.MeetingRepository
import com.example.domain.model.Meeting
import kotlinx.coroutines.flow.Flow

class GetMeetingListUseCase(
    private val repository: MeetingRepository
) {
    operator fun invoke(): Flow<List<Meeting>> {
        return repository.getMeetingList()
    }
}