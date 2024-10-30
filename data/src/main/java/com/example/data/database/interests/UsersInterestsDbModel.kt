package com.example.data.database.interests

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
internal data class UsersInterestsDbModel(
    @PrimaryKey
    val id: Int
)