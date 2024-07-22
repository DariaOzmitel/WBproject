package com.example.wbproject.ui.theme.screens.login.add_profile

import androidx.lifecycle.ViewModel
import com.example.domain.model.User
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

class AddProfileViewModel : ViewModel() {
    private val userMutable = MutableStateFlow(User(name = "", phone = ""))
    private val user: StateFlow<User> = userMutable

    fun getUserFlow(): StateFlow<User> = user

    fun updateName(newName: String) {
        userMutable.update {
            it.copy(name = newName)
        }
    }

    fun updateLastName(newLastName: String) {
        userMutable.update {
            it.copy(lastName = newLastName)
        }
    }
}