package com.example.domain.usecase.interfaces

import com.example.domain.model.Event
import kotlinx.coroutines.flow.Flow

interface IGetEventByIdUseCase {
    operator fun invoke(eventId: Int): Flow<Event>
}