package com.example.domain.usecase

import com.example.domain.MeetingRepository
import com.example.domain.model.Meeting
import com.example.domain.usecase.interfaces.IGetFinishedMeetingListUseCase
import kotlinx.coroutines.flow.Flow

internal class GetFinishedMeetingListUseCase(
    private val repository: MeetingRepository
) : IGetFinishedMeetingListUseCase {
    override operator fun invoke(): Flow<List<Meeting>> {
        return repository.getFinishedMeetingListFlow()
    }
}