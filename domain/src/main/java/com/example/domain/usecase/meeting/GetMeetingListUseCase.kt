package com.example.domain.usecase.meeting

import com.example.domain.model.Meeting
import com.example.domain.repository.MeetingRepository
import com.example.domain.usecase.interfaces.IGetMeetingListUseCase
import kotlinx.coroutines.flow.Flow

internal class GetMeetingListUseCase(
    private val repository: MeetingRepository
) : IGetMeetingListUseCase {
    override operator fun invoke(): Flow<List<Meeting>> {
        return repository.getMeetingListFlow()
    }
}