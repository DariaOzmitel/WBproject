package com.example.ui.screen.profile

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.usecase.interfaces.IGetUserFlowUseCase
import com.example.ui.model.UserUi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

internal class ProfileViewModel(
    private val getUserFlowUseCase: IGetUserFlowUseCase
) :
    ViewModel() {
    private val profileStateMutable: MutableStateFlow<ProfileState> =
        MutableStateFlow(ProfileState.Loading)
    private val profileState: StateFlow<ProfileState> = profileStateMutable

    init {
        viewModelScope.launch {
            getUserById()
        }
    }

    fun getProfileStateFlow(): StateFlow<ProfileState> = profileState

    private fun getUserById() {
        viewModelScope.launch {
            profileStateMutable.update {
                ProfileState.ProfileContent(user = UserUi.mockUserUi)
            }
        }
    }
}