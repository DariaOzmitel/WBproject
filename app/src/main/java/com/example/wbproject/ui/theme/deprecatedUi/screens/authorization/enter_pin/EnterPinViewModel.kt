package com.example.wbproject.ui.theme.deprecatedUi.screens.authorization.enter_pin

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.wbproject.navigation.Screen
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

internal class EnterPinViewModel(private val savedStateHandle: SavedStateHandle) : ViewModel() {

    private val pinMutable = MutableStateFlow("")
    private val pin: StateFlow<String> = pinMutable

    fun getPinFlow(): StateFlow<String> = pin

    fun getPhone(): String {
        return savedStateHandle.get<String>(Screen.KEY_PHONE).orEmpty()
    }

    fun updatePin(newPin: String) {
        pinMutable.value = newPin
    }
}