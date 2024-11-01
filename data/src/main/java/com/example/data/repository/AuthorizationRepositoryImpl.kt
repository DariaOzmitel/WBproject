package com.example.data.repository

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.example.data.database.user.UserDao
import com.example.data.mapper.DbToDomainMapper
import com.example.domain.model.User
import com.example.domain.repository.AuthorizationRepository
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.map

internal class AuthorizationRepositoryImpl(
    private val context: Context,
    private val userDao: UserDao,
    private val mapper: DbToDomainMapper
) :
    AuthorizationRepository {
    @OptIn(ExperimentalCoroutinesApi::class)
    override fun getUserFlow(): Flow<User> {
        return context.dataStore.data.flatMapLatest { preferences ->
            preferences[USER_ID_KEY]?.let { userId ->
                userDao.getUserById(userId).map { mapper.userDbToDomain(it) }
            } ?: emptyFlow()
        }
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    override fun checkAuthorization(): Flow<Boolean> =
        context.dataStore.data.flatMapLatest { preferences ->
            val userId = preferences[USER_ID_KEY]
            when (userId != null) {
                true -> userDao.checkAuthorization(userId)
                false -> flowOf(false)
            }
        }

    override suspend fun addUser(user: User) {
        val userId = userDao.addUser(mapper.userDomainToDb(user))
        context.dataStore.edit { preferences ->
            preferences[USER_ID_KEY] = userId.toInt()
        }
    }

    companion object {
        private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "user")
        private val USER_ID_KEY = intPreferencesKey("user_id")
    }
}