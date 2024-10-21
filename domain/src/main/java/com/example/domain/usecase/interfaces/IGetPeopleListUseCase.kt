package com.example.domain.usecase.interfaces

import com.example.domain.model.User
import kotlinx.coroutines.flow.Flow

interface IGetPeopleListUseCase {
    operator fun invoke(): Flow<List<User>>
}