package com.example.wbproject.ui.theme.elements

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.SearchBar
import androidx.compose.material3.SearchBarDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.tooling.preview.Preview
import com.example.wbproject.ui.theme.LightColors

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun MySearchBar(modifier: Modifier = Modifier) {
    var text by rememberSaveable { mutableStateOf("") }
    SearchBar(
        modifier = modifier,
        query = text,
        onQueryChange = { text = it },
        onSearch = {},
        active = false,
        onActiveChange = {},
        placeholder = { Text("Поиск") },
        leadingIcon = { Icon(Icons.Default.Search, contentDescription = null) },
        shape = RectangleShape,
        colors = SearchBarDefaults.colors(
            containerColor = LightColors.brandColorBackGround,
            dividerColor = LightColors.brandColorBackGround,
            inputFieldColors = TextFieldDefaults.colors(
                unfocusedPlaceholderColor = LightColors.neutralDisabled,
                unfocusedLeadingIconColor = LightColors.neutralDisabled,
                focusedLeadingIconColor = LightColors.neutralDisabled,
                focusedPlaceholderColor = LightColors.neutralDisabled,
                cursorColor = LightColors.neutralActive,
                focusedTextColor = LightColors.neutralActive
            )
        )
    ) {

    }
}
