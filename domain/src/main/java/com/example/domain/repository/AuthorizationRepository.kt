package com.example.domain.repository

import com.example.domain.model.User
import kotlinx.coroutines.flow.Flow

interface AuthorizationRepository {
    fun getUserFlow(): Flow<User>
    fun checkAuthorization(): Flow<Boolean>
    suspend fun addUser(name: String, lastName: String?, avatar: String?)
}