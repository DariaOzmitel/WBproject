package com.example.data.repository

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.example.domain.model.User
import com.example.domain.repository.AuthorizationRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.map

internal class AuthorizationRepositoryImpl(private val context: Context) :
    AuthorizationRepository {
    override fun getUserFlow(): Flow<User> {
        return context.dataStore.data.map { preferences ->
            User(
                id = preferences[USER_ID_KEY] ?: TEST_USER_ID,
                name = preferences[USER_NAME_KEY].orEmpty(),
                lastName = preferences[USER_LASTNAME_KEY],
                avatarUrl = preferences[USER_AVATAR_KEY].orEmpty(),
                phone = preferences[USER_PHONE_KEY].orEmpty()
            )
        }
    }

    override fun checkAuthorization() =
        flowOf(false)
//        context.dataStore.data.map { preferences ->
//        preferences.contains(USER_NAME_KEY)}

    override suspend fun addUser(name: String, lastName: String?, avatar: String?, phone: String) {
        context.dataStore.edit { preferences ->
            preferences[USER_ID_KEY] = TEST_USER_ID
            preferences[USER_NAME_KEY] = name
            preferences[USER_LASTNAME_KEY] = lastName.orEmpty()
            preferences[USER_AVATAR_KEY] = avatar.orEmpty()
            preferences[USER_PHONE_KEY] = phone
        }
    }

    companion object {
        private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "user")
        private val USER_ID_KEY = intPreferencesKey("user_id")
        private val USER_NAME_KEY = stringPreferencesKey("user_name")
        private val USER_LASTNAME_KEY = stringPreferencesKey("user_lastname")
        private val USER_AVATAR_KEY = stringPreferencesKey("user_avatar")
        private val USER_PHONE_KEY = stringPreferencesKey("user_phone")
        private const val TEST_USER_ID = 15
    }

}