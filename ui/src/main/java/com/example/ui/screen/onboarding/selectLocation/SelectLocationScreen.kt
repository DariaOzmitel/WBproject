package com.example.ui.screen.onboarding.selectLocation

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.ui.R

@Composable
internal fun SelectLocationScreen(modifier: Modifier = Modifier, clickListener: () -> Unit) {
    Scaffold { innerPadding ->
        Box(modifier = modifier.padding(top = innerPadding.calculateTopPadding())) {
            Image(
                modifier = Modifier
                    .fillMaxSize()
                    .clickable { clickListener() },
                painter = painterResource(id = R.drawable.map_example),
                contentDescription = ""
            )
        }
    }
}

@Preview
@Composable
private fun SelectLocationScreenPreview() {
    SelectLocationScreen {
    }
}