package com.example.domain.usecase.community

import com.example.domain.model.Community
import com.example.domain.repository.CommunityRepository
import com.example.domain.usecase.interfaces.IGetCommunityUseCase
import kotlinx.coroutines.flow.Flow

internal class GetCommunityUseCase(
    private val repository: CommunityRepository
) : IGetCommunityUseCase {
    override operator fun invoke(communityId: Int): Flow<Community> {
        return repository.getCommunityFlow(communityId)
    }
}