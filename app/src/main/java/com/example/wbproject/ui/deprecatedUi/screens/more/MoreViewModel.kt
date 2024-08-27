package com.example.wbproject.ui.theme.deprecatedUi.screens.more

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.usecase.interfaces.IGetUserFlowUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

internal class MoreViewModel(private val getUserFlowUseCase: IGetUserFlowUseCase) : ViewModel() {
    private val moreStateMutable: MutableStateFlow<MoreState> = MutableStateFlow(MoreState.Loading)
    private val moreState: StateFlow<MoreState> = moreStateMutable

    init {
        viewModelScope.launch {
            getUser()
        }
    }

    fun getMoreStateFlow(): StateFlow<MoreState> = moreState

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