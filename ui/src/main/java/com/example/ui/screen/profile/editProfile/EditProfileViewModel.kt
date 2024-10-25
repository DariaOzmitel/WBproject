package com.example.ui.screen.profile.editProfile

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.usecase.interfaces.IGetUserFlowUseCase
import com.example.ui.model.UserUi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

internal class EditProfileViewModel(
    private val getUserFlowUseCase: IGetUserFlowUseCase
) :
    ViewModel() {
    private val editProfileStateMutable: MutableStateFlow<EditProfileState> =
        MutableStateFlow(EditProfileState.Loading)
    private val editProfileState: StateFlow<EditProfileState> = editProfileStateMutable

    init {
        viewModelScope.launch {
            getUserById()
        }
    }

    fun getEditProfileStateFlow(): StateFlow<EditProfileState> = editProfileState

    private fun getUserById() {
        viewModelScope.launch {
            editProfileStateMutable.update {
                EditProfileState.EditProfileContent(user = UserUi.mockUserUi)
            }
        }
    }
}