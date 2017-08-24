package com.iheartradio.ihearttrivia.categories

import com.iheartradio.ihearttrivia.common.CategoriesApi

class CategoriesModel {

    val api = CategoriesApi()

    fun categories() = api.categories()
}