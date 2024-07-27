package com.example.domain.usecase.interfaces

import com.example.domain.model.Community
import kotlinx.coroutines.flow.Flow

interface IGetCommunityListUseCase {
    operator fun invoke(): Flow<List<Community>>
}