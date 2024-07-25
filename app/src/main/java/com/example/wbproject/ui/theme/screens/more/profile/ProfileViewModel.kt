package com.example.wbproject.ui.theme.screens.more.profile

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.usecase.GetUserUseCase
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

internal class ProfileViewModel(getUserUseCase: GetUserUseCase) : ViewModel() {
    private val profileStateMutable: MutableStateFlow<ProfileState> =
        MutableStateFlow(ProfileState.Loading)
    private val profileState: StateFlow<ProfileState> = profileStateMutable

    fun getProfileStateFlow(): StateFlow<ProfileState> = profileState

    init {
        viewModelScope.launch {
            val user = getUserUseCase.invoke()
            delay(500)
            profileStateMutable.update {
                ProfileState.Profile(user = user)
            }
        }
    }
}