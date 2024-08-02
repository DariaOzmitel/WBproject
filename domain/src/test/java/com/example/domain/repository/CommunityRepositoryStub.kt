package com.example.domain.repository

import com.example.domain.mockData.mockCommunityList
import com.example.domain.model.Community
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

internal class CommunityRepositoryStub : CommunityRepository {
    override fun getCommunityListFlow(): Flow<List<Community>> {
        return flowOf(mockCommunityList)
    }

    override fun getCommunityFlow(communityId: Int): Flow<Community> {
        return flowOf(mockCommunityList.first { it.id == communityId })
    }
}