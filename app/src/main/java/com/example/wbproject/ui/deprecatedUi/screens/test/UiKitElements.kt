package com.example.wbproject.ui.theme.deprecatedUi.screens.test

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.wbproject.ui.theme.deprecatedUi.elements.MyAvatarColumnPreview
import com.example.wbproject.ui.theme.deprecatedUi.elements.MyChipRow
import com.example.wbproject.ui.theme.deprecatedUi.elements.MySearchTextField
import com.example.wbproject.ui.theme.deprecatedUi.elements.forUiKit.MyButtonsPreview
import com.example.wbproject.ui.theme.deprecatedUi.elements.forUiKit.TextColumnForUiKit
import com.example.wbproject.ui.theme.deprecatedUi.theme.MeetingTheme

@Preview
@Composable
fun UiKitElements() {
    var searchText by remember {
        mutableStateOf("")
    }
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .padding(
                top = MeetingTheme.dimensions.dimension80,
                bottom = MeetingTheme.dimensions.dimension80
            )
    ) {
        Column(
            modifier = Modifier
                .padding(MeetingTheme.dimensions.dimension16)
                .padding(8.dp)
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.spacedBy(MeetingTheme.dimensions.dimension8)
        ) {
            MyButtonsPreview()
            TextColumnForUiKit(modifier = Modifier.padding(MeetingTheme.dimensions.dimension8))
            MyAvatarColumnPreview()
            MySearchTextField(searchText = searchText, onValueChange = { searchText = it })
            MyChipRow(modifier = Modifier.padding(start = MeetingTheme.dimensions.dimension8))
        }
    }

}