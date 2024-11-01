package com.example.data.database.user

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
internal interface UserDao {

    @Insert
    suspend fun addUser(user: UserDbModel): Long

    @Query("DELETE FROM UserDbModel WHERE id=:userId")
    suspend fun deleteUser(userId: Int)

    @Query("SELECT COUNT(*) > 0 FROM UserDbModel WHERE id = :userId")
    fun checkAuthorization(userId: Int): Flow<Boolean>

    @Query("SELECT * FROM UserDbModel WHERE id =:userId")
    fun getUserById(userId: Int): Flow<UserDbModel>

    @Query("SELECT * FROM UserDbModel")
    fun getUsersList(): Flow<List<UserDbModel>>
}