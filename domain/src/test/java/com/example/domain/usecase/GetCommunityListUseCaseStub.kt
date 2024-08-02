package com.example.domain.usecase

import com.example.domain.model.Community
import com.example.domain.repository.CommunityRepository
import com.example.domain.usecase.interfaces.IGetCommunityListUseCase
import kotlinx.coroutines.flow.Flow

internal class GetCommunityListUseCaseStub(
    private val repository: CommunityRepository
) : IGetCommunityListUseCase {
    override operator fun invoke(): Flow<List<Community>> {
        return repository.getCommunityListFlow()
    }
}