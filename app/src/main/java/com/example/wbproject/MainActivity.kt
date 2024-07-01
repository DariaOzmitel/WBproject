package com.example.wbproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material3.Icon
import com.example.wbproject.ui.theme.MeetingTheme
import com.example.wbproject.ui.theme.screens.FirstLesson
import com.example.wbproject.ui.theme.screens.MainScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MeetingTheme {
//                FirstLesson()
//                SecondLesson()
                MainScreen()
            }
        }
    }
}
