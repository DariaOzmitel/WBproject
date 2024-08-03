package com.example.domain.model

data class Meeting(
    val id: Int = UNDEFINED_ID,
    val name: String,
    val description: String? = "",
    val imageUrl: String?,
    val date: String,
    val city: String,
    val communityId: Int,
    val chipsList: List<String>?,
    val usersList: MutableList<User> = mutableListOf()
) {
    companion object {
        const val UNDEFINED_ID = 0
    }
}