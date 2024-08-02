package com.example.domain.usecase

import com.example.domain.model.Community
import com.example.domain.repository.CommunityRepository
import com.example.domain.usecase.interfaces.IGetCommunityUseCase
import kotlinx.coroutines.flow.Flow

internal class GetCommunityUseCaseStub(
    private val repository: CommunityRepository
) : IGetCommunityUseCase {
    override operator fun invoke(communityId: Int): Flow<Community> {
        return repository.getCommunityFlow(communityId)
    }
}