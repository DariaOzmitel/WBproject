package com.example.domain.usecase.interfaces

import com.example.domain.model.User
import kotlinx.coroutines.flow.Flow

interface IGetUserFlowUseCase {
    operator fun invoke(): Flow<User>
}