package com.example.wbproject.data.mockData

import androidx.compose.ui.tooling.preview.datasource.LoremIpsum
import com.example.wbproject.model.Community
import com.example.wbproject.model.Meeting
import com.example.wbproject.model.User

val mockUser = User(
    id = 1,
    avatarUrl = "https://static.tildacdn.com/tild6434-6465-4334-a666-316238363037/beautiful-shot-of-tw.jpg",
    name = "Иван",
    lastName = "Иванов",
    phone = "+7 999 999-99-99"
)

val mockListChips = listOf(
    "Python",
    "Junior",
    "Moscow"
)

val mockCommunity = Community(
    id = 1,
    name = "Designa 1",
    imageUrl = "https://infoglaz.ru/wp-content/uploads/1387527274_001.jpg",
    description = LoremIpsum(300).values.first(),
    participantsNumber = 1000
)

val mockCommunityList = mutableListOf<Community>().apply {
    repeat(10) { index ->
        add(
            Community(
                id = index,
                name = "Designa $index",
                imageUrl = "https://infoglaz.ru/wp-content/uploads/1387527274_001.jpg",
                description = LoremIpsum(index * 100).values.first(),
                participantsNumber = index * 1000
            )
        )
    }
}

val mockUserList = mutableListOf<User>().apply {
    repeat(16) { index ->
        add(
            User(
                id = index,
                avatarUrl = "https://pchela.news/storage/app/uploads/public/884/938/9a3/thumb__770_490_0_0_crop.jpg",
                name = "User $index",
                phone = "+7 999 999-99-99"
            )
        )
    }
}

val mockMeeting = Meeting(
    id = 1,
    name = "Developer Meeting 1",
    description = LoremIpsum(300).values.first(),
    imageUrl = "https://icdn.lenta.ru/images/2021/12/28/20/20211228202958360/square_1280_662749ae3f8f3d2f16c96ca21fbd3eba.jpg",
    date = "11.08.24",
    city = "Moscow",
    chipsList = mockListChips,
    usersList = mockUserList,
)

val mockMapUrl =
    "https://s3-alpha-sig.figma.com/img/a7d0/b7a1/73dfa50190eed292a52792c6d52bb4be?Expires=1721606400&Key-Pair-Id=APKAQ4GOSFWCVNEHN3O4&Signature=Lbp~3M0cO0QqU4lp~FXgS4hYwsMVN97j2OZ3HVxb8dEnfLglnfSrPAkaAzJfYEpb69jK3ownyv8GlElutrbD8Ae3vdiQjXpFbOoK-3sgXTVMdTNHCDC7yyRnqwxiCN-9OLFYuwlzvRem139gTzBSrgQ4h0~2T1Gf-XE7I29MM6n3SpJ-xLwwpHaOnDMFG35KkPwHIMVl~RQOSb3CNPrf2CLrbrcuTeLGJdoItKkuEobXERZjHBVTh4PvhxdXMmHiRKykksWEEYGc1UmbH7x~oY1EVQx2UTob2aMF4ro~eu57F8-JthhN3Cd8t9o9Tyi92ZIayuZyICVx9Q7bMzgMoQ__"

val mockListMeetings = listOf(
    mockMeeting,
    Meeting(
        id = 2,
        name = "Developer Meeting 2",
        imageUrl = "https://i.pinimg.com/236x/d0/30/74/d030747fc2368c46f4544a17aa3e4545.jpg",
        date = "11.09.24",
        city = "Penza",
        chipsList = mockListChips
    ),
    Meeting(
        id = 3,
        name = "Developer Meeting 3",
        imageUrl = "https://idel-tat.ru/images/uploads/ckeditor/png/616fef0835992_%D0%A1%D0%BD%D0%B8%D0%BC%D0%BE%D0%BA%20%D1%8D%D0%BA%D1%80%D0%B0%D0%BD%D0%B0%20(2413).png",
        date = "11.10.24",
        city = "Penza",
        chipsList = mockListChips
    ),
    Meeting(
        id = 4,
        name = "Developer Meeting 4",
        imageUrl = "https://go.zvuk.com/thumb/1200x0/filters:quality(75):no_upscale()/imgs/2023/12/13/12/6270663/04ecc42b70ebd4d721214a9138c872e0513e990e.jpg",
        date = "25.08.24",
        city = "London",
        chipsList = mockListChips
    ),
    Meeting(
        id = 5,
        name = "Developer Meeting 5",
        imageUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTJjJZbftGj17szrlBHTmq9VvDfwouZWOcEGg&s",
        date = "30.08.24",
        city = "Moscow",
        chipsList = mockListChips
    ),
    Meeting(
        id = 6,
        name = "Developer Meeting 6",
        imageUrl = "https://englishtochka.ru/wp-content/uploads/blog/m/m1.jpg",
        date = "19.08.24",
        city = "Moscow",
        chipsList = mockListChips
    )
)

val mockListMeetingAlreadyPassed = listOf(
    mockMeeting,
    mockMeeting,
)