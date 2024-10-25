package com.example.data.repository

import com.example.data.mockData.mockAllInterests
import com.example.domain.model.Interest
import com.example.domain.repository.InterestsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class InterestsRepositoryImpl : InterestsRepository {

    override fun loadAllInterests(): Flow<List<Interest>> {
        return flowOf(mockAllInterests)
    }
}