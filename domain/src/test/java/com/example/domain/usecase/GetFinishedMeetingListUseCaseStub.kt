package com.example.domain.usecase

import com.example.domain.model.Event
import com.example.domain.repository.EventsRepository
import com.example.domain.usecase.interfaces.IGetFinishedMeetingListUseCase
import kotlinx.coroutines.flow.Flow

internal class GetFinishedMeetingListUseCaseStub(
    private val repository: EventsRepository
) : IGetFinishedMeetingListUseCase {
    override operator fun invoke(): Flow<List<Event>> {
        return repository.getFinishedEventsListFlow()
    }
}