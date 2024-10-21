package com.example.ui.screen.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.ui.R
import com.example.ui.theme.EventTheme
import org.koin.androidx.compose.koinViewModel

@Composable
fun SplashScreen(modifier: Modifier = Modifier, animationEndListener: (Boolean) -> Unit) {
    val viewModel: SplashScreenViewModel = koinViewModel()
    val authorizationStatus by viewModel.getStatusFlow().collectAsStateWithLifecycle()
    Scaffold { innerPadding ->
        Box(modifier = modifier.padding(top = innerPadding.calculateTopPadding())) {
            Image(
                modifier = Modifier.fillMaxSize(),
                painter = painterResource(id = R.drawable.splash_screen),
                contentDescription = ""
            )
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    modifier = Modifier
                        .width(EventTheme.dimensions.dimension126)
                        .padding(bottom = EventTheme.dimensions.dimension20),
                    painter = painterResource(id = R.drawable.wb),
                    contentDescription = "",
                    contentScale = ContentScale.FillWidth
                )
                Image(
                    modifier = Modifier.width(EventTheme.dimensions.dimension320),
                    painter = painterResource(id = R.drawable.events),
                    contentDescription = "",
                    contentScale = ContentScale.FillWidth
                )
            }
            viewModel.checkAuthorization { animationEndListener(it) }
        }
    }
}

@Preview
@Composable
private fun SplashScreenPreview() {
    SplashScreen {}
}