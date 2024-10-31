package com.example.domain.usecase.event

import com.example.domain.model.Event
import com.example.domain.repository.EventsRepository
import com.example.domain.usecase.interfaces.IGetFinishedEventsListUseCase
import kotlinx.coroutines.flow.Flow

internal class GetFinishedEventsListUseCase(
    private val repository: EventsRepository
) : IGetFinishedEventsListUseCase {
    override operator fun invoke(): Flow<List<Event>> {
        return repository.getFinishedEventsListFlow()
    }
}