package com.example.domain.model

data class Community(
    val id: Int,
    val name: String,
    val imageUrl: String?,
    val description: String?,
    val participantsNumber: Int,
)