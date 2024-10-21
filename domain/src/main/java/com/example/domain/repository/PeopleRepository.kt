package com.example.domain.repository

import com.example.domain.model.User
import kotlinx.coroutines.flow.Flow

interface PeopleRepository {
    fun getPeopleListFlow(): Flow<List<User>>
    fun getPersonFlow(personId: Int): Flow<User>
}