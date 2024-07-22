package com.example.wbproject.ui.theme.screens.more

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.usecase.GetUserUseCase
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class MoreViewModel(getUserUseCase: GetUserUseCase) : ViewModel() {
    private val moreStateMutable: MutableStateFlow<MoreState> = MutableStateFlow(MoreState.Loading)
    private val moreState: StateFlow<MoreState> = moreStateMutable

    fun getMoreStateFlow(): StateFlow<MoreState> = moreState

    init {
        viewModelScope.launch {
            val user = getUserUseCase.invoke()
            delay(500)
            moreStateMutable.update {
                MoreState.MoreUser(user = user)
            }
        }
    }
}