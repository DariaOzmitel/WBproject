package com.example.data.database.interests

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
internal interface InterestsDao {

    @Insert
    suspend fun addUsersInterest(interestsId: UsersInterestsDbModel)

    @Query("DELETE FROM UsersInterestsDbModel WHERE id=:interestId")
    suspend fun deleteUsersInterest(interestId: Int)

    @Query("SELECT COUNT(*) > 0 FROM UsersInterestsDbModel WHERE id = :interestId")
    suspend fun isInterestSelected(interestId: Int): Boolean

    @Query("SELECT * FROM InterestDbModel")
    fun getInterestsList(): Flow<List<InterestDbModel>>

    @Query(
        """
        SELECT * FROM InterestDbModel 
        INNER JOIN UsersInterestsDbModel 
        ON InterestDbModel.id = UsersInterestsDbModel.id
    """
    )
    fun getUsersInterests(): Flow<List<InterestDbModel>>


}