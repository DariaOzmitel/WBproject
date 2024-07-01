package com.example.wbproject.ui.theme.elements

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.wbproject.ui.theme.LightColors
import com.example.wbproject.ui.theme.MeetingTheme

@Preview
@Composable
fun MySearchTextField() {
    var text by rememberSaveable { mutableStateOf("") }

    OutlinedTextField(
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp),
        shape = RectangleShape,
        value = text,
        placeholder = { Text(text = "Поиск", color = MeetingTheme.colors.neutralWeak) },
        onValueChange = { text = it },
        leadingIcon = {
            Icon(
                Icons.Filled.Search,
                contentDescription = "Search",
                tint = MeetingTheme.colors.neutralWeak
            )
        },
        colors = TextFieldDefaults.colors(
            unfocusedContainerColor = LightColors.brandColorBackGround,
            focusedLeadingIconColor = LightColors.neutralDisabled,
            focusedContainerColor = LightColors.brandColorBackGround,
            unfocusedIndicatorColor = Color.Transparent,
            focusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent,
        )
    )
}