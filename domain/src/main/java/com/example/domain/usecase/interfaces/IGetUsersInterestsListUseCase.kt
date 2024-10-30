package com.example.domain.usecase.interfaces

import com.example.domain.model.Interest
import kotlinx.coroutines.flow.Flow

interface IGetUsersInterestsListUseCase {
    operator fun invoke(): Flow<List<Interest>>
}