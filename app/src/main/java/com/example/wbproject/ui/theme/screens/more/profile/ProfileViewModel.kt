package com.example.wbproject.ui.theme.screens.more.profile

import androidx.lifecycle.ViewModel
import com.example.wbproject.data.mockData.mockUser
import com.example.wbproject.model.User
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class ProfileViewModel : ViewModel() {
    private val userMutable = MutableStateFlow(mockUser)
    private val user: StateFlow<User> = userMutable

    fun getUserFlow(): StateFlow<User> = user
}