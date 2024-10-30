package com.example.data.database.interests

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
internal data class InterestDbModel(
    @PrimaryKey
    val id: Int,
    val name: String
)
