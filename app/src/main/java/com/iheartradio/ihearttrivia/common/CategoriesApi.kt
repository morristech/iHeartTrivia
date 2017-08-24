package com.iheartradio.ihearttrivia.common

import io.reactivex.rxkotlin.toSingle

class CategoriesApi {

    val categories = arrayOf(Category(1, "Android Team"),
            Category(2, "Colors"),
            Category(3, "Cities"),
            Category(4, "Food"),
            Category(5, "Nature"))

    fun categories() = categories.toSingle()
}