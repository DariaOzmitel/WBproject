package com.example.data.database.user

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
internal data class UserDbModel(
    @PrimaryKey
    val id: Int,
    val avatarModel: String?,
    val name: String,
    val lastName: String?,
    val phone: String,
    val city: String?,
)
