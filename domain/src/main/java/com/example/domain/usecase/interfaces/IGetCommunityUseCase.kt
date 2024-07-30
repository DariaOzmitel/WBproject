package com.example.domain.usecase.interfaces

import com.example.domain.model.Community
import kotlinx.coroutines.flow.Flow

interface IGetCommunityUseCase {
    operator fun invoke(communityId: Int): Flow<Community>
}