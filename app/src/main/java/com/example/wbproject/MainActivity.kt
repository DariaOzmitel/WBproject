package com.example.wbproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.ui.screen.profile.editProfile.EditProfileScreen
import com.example.ui.theme.EventTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            EventTheme {
//                SplashScreen {}
//                SelectInterestScreen()
//                SelectLocationScreen {
//                }
//                InstallMainNavGraph()
//                UiMoleculesScreen()
//                UiElementsScreen()
//                MainPageScreen()
//                PeopleScreen(peopleList = mockUserList) {}
//                EventScreen(meeting = mockMeeting)
//                CommunityScreen()
//                EnterNameScreen()
//                EnterPhoneScreen()
//                EnterPinScreen()
//                ConfirmedEventScreen()
//                DeleteProfileScreen()
//                ProfileScreen()
                EditProfileScreen()
            }
        }
    }
}
