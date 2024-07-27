package com.example.wbproject.ui.theme.screens.more

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.usecase.GetUserFlowUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

internal class MoreViewModel(private val getUserFlowUseCase: GetUserFlowUseCase) : ViewModel() {
    private val moreStateMutable: MutableStateFlow<MoreState> = MutableStateFlow(MoreState.Loading)
    private val moreState: StateFlow<MoreState> = moreStateMutable

    fun getMoreStateFlow(): StateFlow<MoreState> = moreState

    init {
        viewModelScope.launch {
            getUser()
        }
    }

    private fun getUser() {
        viewModelScope.launch {
            getUserFlowUseCase().collect { user ->
                moreStateMutable.update {
                    MoreState.MoreUser(user = user)
                }
            }
        }
    }
}