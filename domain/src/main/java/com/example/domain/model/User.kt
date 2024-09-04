package com.example.domain.model

data class User(
    val id: Int = UNDEFINED_ID,
    val avatarUrl: String?,
    val name: String,
    val lastName: String? = "",
    val phone: String,
    val interests: List<Interest>? = null
) {
    companion object {
        const val UNDEFINED_ID = -1
    }
}
