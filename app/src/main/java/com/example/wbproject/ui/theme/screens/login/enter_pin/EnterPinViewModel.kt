package com.example.wbproject.ui.theme.screens.login.enter_pin

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

internal class EnterPinViewModel : ViewModel() {

    private val pinMutable = MutableStateFlow("")
    private val pin: StateFlow<String> = pinMutable

    fun getPinFlow(): StateFlow<String> = pin

    fun updatePin(newPin: String) {
        pinMutable.value = newPin
    }
}