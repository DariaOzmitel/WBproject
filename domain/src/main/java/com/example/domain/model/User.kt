package com.example.domain.model

data class User(
    val id: Int = UNDEFINED_ID,
    val avatarModel: Any?,
    val name: String,
    val lastName: String? = "",
    val phone: String,
    val city: String? = null,
    val interests: List<Interest>? = null
) {
    companion object {
        const val UNDEFINED_ID = -1
    }
}
