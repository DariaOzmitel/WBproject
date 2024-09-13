package com.example.domain.model

data class Presenter(
    val id: Int = UNDEFINED_ID,
    val avatarModel: Any?,
    val name: String,
    val description: String?,
) {
    companion object {
        const val UNDEFINED_ID = -1
    }
}
