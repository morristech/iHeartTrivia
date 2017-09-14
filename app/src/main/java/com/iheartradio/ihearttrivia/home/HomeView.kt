package com.iheartradio.ihearttrivia.home

import android.view.View
import com.iheartradio.ihearttrivia.R
import io.reactivex.Observable
import io.reactivex.subjects.PublishSubject
import kotlinx.android.synthetic.main.activity_main.view.*

/**
 * Created by hwang on 8/17/17.
 */
class HomeView(val view: View) {

    init {
        view.selectCategory.setOnClickListener { onCategoiesClicked.onNext(Unit) }
        view.startGame.setOnClickListener { onGameStartClicked.onNext(Unit) }
    }

    private val onCategoiesClicked = PublishSubject.create<Unit>()
    private val onGameStartClicked = PublishSubject.create<Unit>()

    fun getOnCategoiesClicked() : Observable<Unit> {
        return onCategoiesClicked
    }

    fun getOnGameStartClicked() : Observable<Unit> {
        return onGameStartClicked
    }

    fun updateCategoryText(categoryName : String) {
        view.selectCategory.text = categoryName
    }

}