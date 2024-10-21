package com.example.domain.usecase.interfaces

import com.example.domain.model.User
import kotlinx.coroutines.flow.Flow

interface IGetPersonFlowUseCase {
    operator fun invoke(personId: Int): Flow<User>
}