package com.example.data.repository

import com.example.data.mockData.mockUserList
import com.example.domain.model.User
import com.example.domain.repository.PeopleRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class PeopleRepositoryImpl : PeopleRepository {
    override fun getPeopleListFlow(): Flow<List<User>> {
        return flowOf(mockUserList)
    }

    override fun getPersonFlow(personId: Int): Flow<User> {
        return flowOf(mockUserList.first { it.id == personId })
    }
}