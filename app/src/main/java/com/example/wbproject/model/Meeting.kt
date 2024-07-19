package com.example.wbproject.model

data class Meeting(
    val id: Int = UNDEFINED_ID,
    val name: String,
    val description: String? = "",
    val imageUrl: String?,
    val date: String,
    val city: String,
    val chipsList: List<String>?,
    val usersList: List<User>? = null
) {
    companion object {
        const val UNDEFINED_ID = 0
    }
}