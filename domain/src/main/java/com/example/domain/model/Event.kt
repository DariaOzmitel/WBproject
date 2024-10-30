package com.example.domain.model

data class Event(
    val id: Int = UNDEFINED_ID,
    val name: String,
    val description: String? = "",
    val imageUrl: String?,
    val date: String,
    val city: String,
    val address: String = "",
    val presenter: Presenter? = null,
    val communityId: Int,
    val chipsList: List<Interest>?,
    val usersList: MutableList<User> = mutableListOf()
) {
    companion object {
        const val UNDEFINED_ID = 0
    }
}