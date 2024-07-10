package com.example.wbproject.ui.theme.screens.test

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.wbproject.ui.theme.elements.CustomPhoneNumber
import com.example.wbproject.ui.theme.elements.CustomPin

@Composable
fun CustomViewScreen() {

    Column(modifier = Modifier.padding(top = 100.dp, start = 50.dp)) {
        CustomPin()
        Spacer(modifier = Modifier.height(80.dp))
        CustomPhoneNumber()
    }
}