package com.iheartradio.ihearttrivia.home

import android.widget.Toast
import com.iheartradio.ihearttrivia.common.CategoriesApi
import com.iheartradio.ihearttrivia.common.Category
import io.reactivex.Maybe
import io.reactivex.rxkotlin.toObservable
import io.reactivex.rxkotlin.toSingle

/**
 * Created by hwang on 8/17/17.
 */
class HomeModel {

    fun getCategoryById(categoryId: Int): Maybe<Category> {
        val categoryApi = CategoriesApi()

        return categoryApi.categories()
                .flatMapObservable { it.toObservable() }
                .filter { it.id == categoryId }
                .firstElement()

    }
}