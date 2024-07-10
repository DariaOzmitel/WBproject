package com.example.wbproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.wbproject.ui.theme.MeetingTheme
import com.example.wbproject.ui.theme.screens.CustomViewScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MeetingTheme {
//                MainScreen()
                CustomViewScreen()

            }
        }
    }
}
