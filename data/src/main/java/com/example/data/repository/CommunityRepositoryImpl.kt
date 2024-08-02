package com.example.data.repository

import com.example.data.mockData.mockCommunityList
import com.example.domain.model.Community
import com.example.domain.repository.CommunityRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

internal class CommunityRepositoryImpl : CommunityRepository {
    override fun getCommunityListFlow(): Flow<List<Community>> {
        return flowOf(mockCommunityList)
    }

    override fun getCommunityFlow(communityId: Int): Flow<Community> {
        return flowOf(mockCommunityList.first { it.id == communityId })
    }
}