package com.example.domain.usecase.interfaces

import com.example.domain.model.Event
import kotlinx.coroutines.flow.Flow

interface IGetEventListUseCase {
    operator fun invoke(): Flow<List<Event>>
}