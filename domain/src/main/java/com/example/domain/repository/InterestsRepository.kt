package com.example.domain.repository

import com.example.domain.model.Interest
import kotlinx.coroutines.flow.Flow

interface InterestsRepository {
    fun loadAllInterests(): Flow<List<Interest>>
}