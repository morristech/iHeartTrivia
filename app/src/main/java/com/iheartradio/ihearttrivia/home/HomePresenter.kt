package com.iheartradio.ihearttrivia.home

import android.app.Activity
import android.content.Intent
import com.iheartradio.ihearttrivia.categories.CategoriesActivity
import com.iheartradio.ihearttrivia.gameplay.GameplayActivity
import io.reactivex.disposables.CompositeDisposable

/**
 * Created by hwang on 8/17/17.
 */
class HomePresenter {
    val disposables: CompositeDisposable = CompositeDisposable()
    fun bindView(activity: Activity, homeView: HomeView) {
        disposables.add(homeView.getOnCategoiesClicked().subscribe({ activity.startActivityForResult<CategoriesActivity>(CategoriesActivity.CATEGORIES_RESULT_CODE)}))
        disposables.add(homeView.getOnGameStartClicked().subscribe({ activity.navigateToActivity<GameplayActivity>() }))
    }


    fun unbindView() {
        disposables.clear()
    }



}

// inline to indicate it is generic
// reified only works with inline

inline fun <reified T:Activity> Activity.navigateToActivity () {
    startActivity(Intent(this, T::class.java))
}

inline fun <reified T:Activity> Activity.startActivityForResult (resultCode:Int) {
    startActivityForResult(Intent(this, T::class.java), resultCode)
}