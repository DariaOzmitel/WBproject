package com.example.domain.usecase

import com.example.domain.MeetingRepository
import com.example.domain.model.Community
import com.example.domain.usecase.interfaces.IGetCommunityUseCase
import kotlinx.coroutines.flow.Flow

internal class GetCommunityUseCase(
    private val repository: MeetingRepository
) : IGetCommunityUseCase {
    override operator fun invoke(communityId: Int): Flow<Community> {
        return repository.getCommunityFlow(communityId)
    }
}