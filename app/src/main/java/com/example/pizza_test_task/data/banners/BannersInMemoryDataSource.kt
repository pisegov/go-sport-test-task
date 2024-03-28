package com.example.pizza_test_task.data.banners

import com.example.pizza_test_task.di.ApplicationScope
import com.example.pizza_test_task.domain.model.Banner
import javax.inject.Inject

@ApplicationScope
class BannersInMemoryDataSource @Inject constructor() {
    val banners = listOf(
        Banner("https://img.freepik.com/free-photo/top-view-chips-bowl-yellow-background_23-2148582668.jpg?t=st=1711623784~exp=1711624384~hmac=18f6ca25d6dadebbb921e8616862b77838b569ddb6ffec2f1f2d423d738a1816"),
        Banner("https://img.freepik.com/free-photo/side-view-chips-glass-bowl-horizontal_176474-1050.jpg?t=st=1711623794~exp=1711624394~hmac=48073e715aa33cc8d60d4898fbebf4589ec283dc270dc81d19a1cf9247fdc4fb"),
        Banner("https://img.freepik.com/free-photo/hawaiian-pizza-wooden-tray_74190-6940.jpg?t=st=1711624232~exp=1711624832~hmac=fec747ef2d081279ce12609c41baa33c51d909f2cb218679c42a7b3dc14a162b"),
        Banner("https://img.freepik.com/free-photo/flat-lay-edamame-beans-bowl-with-copy-space_23-2148368704.jpg?t=st=1711623784~exp=1711624384~hmac=fb6283b9b2c21a25628f808219464539a7fca456157d96e2034b1a15405eb48c"),
    )
}