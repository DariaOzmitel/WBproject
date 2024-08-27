package com.example.wbproject.ui.theme.deprecatedUi.screens.authorization.enter_phone

import com.example.wbproject.ui.theme.deprecatedUi.items.DropdownMenuItems

sealed class EnterPhoneState {
    data class EnterPhoneContent(
        val countryCode: DropdownMenuItems,
        val isMenuExpanded: Boolean = false,
        val phone: String = ""
    ) : EnterPhoneState()

    object Loading : EnterPhoneState()
}
