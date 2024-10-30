package com.example.domain.usecase.event

import com.example.domain.model.Event
import com.example.domain.repository.EventsRepository
import com.example.domain.usecase.interfaces.IGetEventByIdUseCase
import kotlinx.coroutines.flow.Flow

internal class GetEventByIdUseCase(
    private val repository: EventsRepository
) : IGetEventByIdUseCase {
    override operator fun invoke(eventId: Int): Flow<Event> {
        return repository.getEventFlow(eventId)
    }
}