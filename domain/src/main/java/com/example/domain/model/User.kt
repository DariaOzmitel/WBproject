package com.example.domain.model

data class User(
    val id: Int = UNDEFINED_ID,
    val avatarUrl: String = DEFAULT_AVATAR_URL,
    val name: String,
    val lastName: String? = null,
    val phone: String
) {
    companion object {
        const val UNDEFINED_ID = -1
        const val DEFAULT_AVATAR_URL = "https://upload.wikimedia.org/wikipedia/ru/4/4d/Wojak.png"
    }
}
