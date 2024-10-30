package com.example.ui

import com.example.domain.model.Community
import com.example.domain.model.Event
import com.example.domain.model.Interest
import com.example.domain.model.Presenter
import com.example.domain.model.User
import com.example.ui.model.InterestUi

const val mockDescription =
    "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Praesent ac tortor efficitur, posuere diam quis, hendrerit urna. Proin venenatis ipsum tellus, sit amet consequat leo fringilla nec. Nulla sem odio, posuere ut elit at, efficitur malesuada purus. Integer neque justo, finibus quis mi vitae, imperdiet lacinia nisl. Nam nunc turpis, ultricies vitae rhoncus fringilla, congue id nisl. Donec eros est, auctor vitae urna a, vestibulum porta lacus. Aenean consequat, mauris vel congue pellentesque, diam leo fermentum enim, at congue tellus orci eu ligula. Fusce ipsum elit, egestas vitae purus sit amet, tristique suscipit nisi. Mauris volutpat nisl sit amet pharetra dapibus.\n" +
            "\n" +
            "Mauris libero felis, lacinia a maximus nec, sollicitudin id urna. Nunc convallis lorem lorem, ut lobortis dui venenatis quis. Vestibulum ex magna, elementum ut nibh egestas, tempor mattis lectus. Suspendisse vel erat sapien. Fusce nisi odio, consectetur eu consequat at, laoreet sit amet diam. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Phasellus pellentesque libero lorem, ac ultricies mauris imperdiet a.\n" +
            "\n" +
            "Donec commodo nulla vel mattis tincidunt. Fusce et mollis leo, in ultricies arcu. Donec id posuere orci, et venenatis quam. Suspendisse imperdiet dignissim ligula in aliquet. Curabitur leo erat, interdum in nibh sit amet, tempus tristique lectus. Vestibulum consequat tortor metus, at pulvinar dolor luctus vitae. Aliquam nulla quam, ornare eu nunc sit amet, maximus convallis dui. Sed eu imperdiet enim. Integer ut nulla ut tellus mollis rhoncus a vel urna. Sed pellentesque finibus sem a aliquam. Duis eu sapien nisi.\n" +
            "\n" +
            "Maecenas ante tortor, feugiat eu suscipit vitae, semper aliquet metus. Ut vestibulum tempus sem, at sodales lorem condimentum ac. Vestibulum varius ornare massa, ac maximus velit aliquet quis. Praesent pretium leo lectus, dictum blandit enim luctus at. Sed fermentum massa sem. Nunc volutpat lorem id posuere congue. Nulla facilisi. Nam ac mattis."

val mockAllInterests = listOf(
    InterestUi(0, "Дизайн", true),
    InterestUi(1, "Разработка", true),
    InterestUi(2, "Продакт менеджмент", false),
    InterestUi(3, "Проджект менеджмент", true),
    InterestUi(4, "Backend", true),
    InterestUi(5, "Frontend", false),
    InterestUi(6, "Mobile", false),
    InterestUi(7, "Тестирование", false),
    InterestUi(8, "Продажи", false),
    InterestUi(9, "Бизнес", false),
    InterestUi(10, "Безопасность", true),
    InterestUi(11, "Web", false),
    InterestUi(12, "Девопс", true),
    InterestUi(13, "Маркетинг", false),
    InterestUi(14, "Аналитика", false),
)

val mockInterests = listOf(
    Interest(0, "Дизайн"),
    Interest(1, "Разработка"),
    Interest(5, "Frontend"),
    Interest(7, "Тестирование"),
    Interest(12, "Девопс"),
)

val mockPresenter = Presenter(
    id = 1,
    avatarModel = "https://static.tildacdn.com/tild6434-6465-4334-a666-316238363037/beautiful-shot-of-tw.jpg",
    name = "Павел Хориков",
    description = "Ведущий специалист по подбору персонала в одной из крупнейших IT-компаний в ЕС."
)

val mockUser = User(
    id = 1,
    avatarModel = "https://static.tildacdn.com/tild6434-6465-4334-a666-316238363037/beautiful-shot-of-tw.jpg",
    name = "Иван",
    lastName = "Иванов",
    phone = "+7 999 999-99-99",
    interests = mockInterests,
)

val mockListChips = listOf(
    "Python",
    "Junior",
    "Moscow"
)

val mockCommunity = Community(
    id = 1,
    name = "Супер длинное название сообщества, чтобы посмотреть как обрежется",
    imageUrl = "https://infoglaz.ru/wp-content/uploads/1387527274_001.jpg",
    description = mockDescription,
    participantsNumber = 1000,
    interests = mockInterests
)

val mockCommunityList = mutableListOf<Community>().apply {
    repeat(10) { index ->
        add(
            Community(
                id = index,
                name = "Designa $index",
                imageUrl = "https://infoglaz.ru/wp-content/uploads/1387527274_001.jpg",
                description = mockDescription,
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
                avatarModel = "https://pchela.news/storage/app/uploads/public/884/938/9a3/thumb__770_490_0_0_crop.jpg",
                name = "User $index",
                phone = "+7 999 999-99-99",
                interests = mockInterests
            )
        )
    }
}

val mockEvent = Event(
    id = 1,
    name = "Developer Meeting 1",
    description = mockDescription,
    imageUrl = "https://icdn.lenta.ru/images/2021/12/28/20/20211228202958360/square_1280_662749ae3f8f3d2f16c96ca21fbd3eba.jpg",
    date = "11.08.24",
    city = "Moscow",
    address = "Севкабель Порт, Кожевенная линия, 40,",
    presenter = mockPresenter,
    communityId = mockCommunity.id,
    chipsList = mockInterests,
    usersList = mockUserList,
)

val mockMapUrl =
    "https://s3-alpha-sig.figma.com/img/a7d0/b7a1/73dfa50190eed292a52792c6d52bb4be?Expires=1721606400&Key-Pair-Id=APKAQ4GOSFWCVNEHN3O4&Signature=Lbp~3M0cO0QqU4lp~FXgS4hYwsMVN97j2OZ3HVxb8dEnfLglnfSrPAkaAzJfYEpb69jK3ownyv8GlElutrbD8Ae3vdiQjXpFbOoK-3sgXTVMdTNHCDC7yyRnqwxiCN-9OLFYuwlzvRem139gTzBSrgQ4h0~2T1Gf-XE7I29MM6n3SpJ-xLwwpHaOnDMFG35KkPwHIMVl~RQOSb3CNPrf2CLrbrcuTeLGJdoItKkuEobXERZjHBVTh4PvhxdXMmHiRKykksWEEYGc1UmbH7x~oY1EVQx2UTob2aMF4ro~eu57F8-JthhN3Cd8t9o9Tyi92ZIayuZyICVx9Q7bMzgMoQ__"

val mockListEvents = mutableListOf(
    mockEvent,
    Event(
        id = 2,
        name = "Developer Meeting 2",
        description = mockDescription,
        imageUrl = "https://i.pinimg.com/236x/d0/30/74/d030747fc2368c46f4544a17aa3e4545.jpg",
        date = "11.09.24",
        city = "Penza",
        presenter = mockPresenter,
        chipsList = mockInterests,
        communityId = mockCommunity.id,
        usersList = mockUserList
    ),
    Event(
        id = 3,
        name = "Developer Meeting 3",
        description = mockDescription,
        imageUrl = "https://idel-tat.ru/images/uploads/ckeditor/png/616fef0835992_%D0%A1%D0%BD%D0%B8%D0%BC%D0%BE%D0%BA%20%D1%8D%D0%BA%D1%80%D0%B0%D0%BD%D0%B0%20(2413).png",
        date = "11.10.24",
        city = "Penza",
        chipsList = mockInterests,
        communityId = 2
    ),
    Event(
        id = 4,
        name = "Developer Meeting 4",
        description = mockDescription,
        imageUrl = "https://go.zvuk.com/thumb/1200x0/filters:quality(75):no_upscale()/imgs/2023/12/13/12/6270663/04ecc42b70ebd4d721214a9138c872e0513e990e.jpg",
        date = "25.08.24",
        city = "London",
        chipsList = mockInterests,
        communityId = 3,
        usersList = mockUserList
    ),
    Event(
        id = 5,
        name = "Developer Meeting 5",
        description = mockDescription,
        imageUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTJjJZbftGj17szrlBHTmq9VvDfwouZWOcEGg&s",
        date = "30.08.24",
        city = "Moscow",
        chipsList = mockInterests,
        communityId = 4,
        usersList = mockUserList
    ),
    Event(
        id = 6,
        name = "Developer Meeting 6",
        description = mockDescription,
        imageUrl = "https://englishtochka.ru/wp-content/uploads/blog/m/m1.jpg",
        date = "19.08.24",
        city = "Moscow",
        chipsList = mockInterests,
        communityId = mockCommunity.id
    )
)

val mockListEventAlreadyPasseds = listOf(
    Event(
        id = 5,
        name = "Developer Meeting 5",
        description = mockDescription,
        imageUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTJjJZbftGj17szrlBHTmq9VvDfwouZWOcEGg&s",
        date = "30.08.24",
        city = "Moscow",
        chipsList = mockInterests,
        communityId = 4
    ),
    Event(
        id = 6,
        name = "Developer Meeting 6",
        description = mockDescription,
        imageUrl = "https://englishtochka.ru/wp-content/uploads/blog/m/m1.jpg",
        date = "19.08.24",
        city = "Moscow",
        chipsList = mockInterests,
        communityId = mockCommunity.id
    )
)