package com.example.wbproject.ui.theme.screens.authorization.add_profile

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.model.User
import com.example.domain.usecase.interfaces.IAddUserUseCase
import com.example.wbproject.navigation.Screen
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

internal class AddProfileViewModel(
    private val addUserUseCase: IAddUserUseCase,
    private val savedStateHandle: SavedStateHandle,
) : ViewModel() {
    private val userMutable = MutableStateFlow(User(name = "", avatarUrl = "", phone = ""))
    private val user: StateFlow<User> = userMutable

    fun getUserFlow(): StateFlow<User> = user

    fun updateName(newName: String) {
        userMutable.update {
            it.copy(name = newName.trim())
        }
    }

    fun updateLastName(newLastName: String) {
        userMutable.update {
            it.copy(lastName = newLastName.trim())
        }
    }

    fun updateAvatar(newAvatarUrl: String) {
        userMutable.update {
            it.copy(avatarUrl = newAvatarUrl)
        }
    }

    fun addUser() {
        viewModelScope.launch {
            addUserUseCase.invoke(
                name = user.value.name,
                lastName = user.value.lastName,
                avatar = user.value.avatarUrl,
                phone = getPhone()
            )
        }
    }

    private fun getPhone(): String {
        return savedStateHandle.get<String>(Screen.KEY_PHONE).orEmpty()
    }
}