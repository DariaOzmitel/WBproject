package com.example.domain.usecase

import com.example.domain.MeetingRepository
import com.example.domain.model.Community
import kotlinx.coroutines.flow.Flow

class GetCommunityUseCase(
    private val repository: MeetingRepository
) {
    operator fun invoke(communityId: Int): Flow<Community> {
        return repository.getCommunityFlow(communityId)
    }
}