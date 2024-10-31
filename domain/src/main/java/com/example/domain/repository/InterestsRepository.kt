package com.example.domain.repository

import com.example.domain.model.Interest
import kotlinx.coroutines.flow.Flow

interface InterestsRepository {
    fun getAllInterests(): Flow<List<Interest>>
    fun getUsersInterests(): Flow<List<Interest>>
    suspend fun changeUsersInterest(interestId: Int)
}