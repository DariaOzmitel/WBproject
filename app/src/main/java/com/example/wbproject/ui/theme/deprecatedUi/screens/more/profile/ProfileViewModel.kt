package com.example.wbproject.ui.theme.deprecatedUi.screens.more.profile

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.usecase.interfaces.IGetUserFlowUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

internal class ProfileViewModel(private val getUserFlowUseCase: IGetUserFlowUseCase) : ViewModel() {
    private val profileStateMutable: MutableStateFlow<ProfileState> =
        MutableStateFlow(ProfileState.Loading)
    private val profileState: StateFlow<ProfileState> = profileStateMutable

    init {
        viewModelScope.launch {
            getUserFlow()
        }
    }

    fun getProfileStateFlow(): StateFlow<ProfileState> = profileState

    private fun getUserFlow() {
        viewModelScope.launch {
            getUserFlowUseCase().collect { user ->
                profileStateMutable.update {
                    ProfileState.Profile(user = user)
                }
            }
        }
    }
}