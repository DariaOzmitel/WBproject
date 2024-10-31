package com.example.domain.usecase

import com.example.domain.model.Event
import com.example.domain.repository.EventsRepository
import com.example.domain.usecase.interfaces.IGetEventListUseCase
import kotlinx.coroutines.flow.Flow

internal class GetEventListUseCaseStub(
    private val repository: EventsRepository
) : IGetEventListUseCase {
    override operator fun invoke(): Flow<List<Event>> {
        return repository.getEventsListFlow()
    }
}