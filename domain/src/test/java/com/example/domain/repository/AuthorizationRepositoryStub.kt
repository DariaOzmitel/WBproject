package com.example.domain.repository

import com.example.domain.mockData.mockUser
import com.example.domain.model.User
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

internal class AuthorizationRepositoryStub : AuthorizationRepository {
    override fun getUserFlow(): Flow<User> {
        return flowOf(mockUser)
    }

    override fun checkAuthorization(): Flow<Boolean> {
        TODO("Not yet implemented")
    }

    override suspend fun addUser(name: String, lastName: String?, avatar: String?, phone: String) {
        TODO("Not yet implemented")
    }

}