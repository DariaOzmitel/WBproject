package com.example.domain.repository

import com.example.domain.model.Community
import kotlinx.coroutines.flow.Flow

interface CommunityRepository {
    fun getCommunityListFlow(): Flow<List<Community>>
    fun getCommunityFlow(communityId: Int): Flow<Community>
}