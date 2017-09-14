package com.iheartradio.ihearttrivia.home

import android.app.Activity
import android.content.Intent
import android.widget.Toast
import com.iheartradio.ihearttrivia.categories.CategoriesActivity
import com.iheartradio.ihearttrivia.common.Category
import com.iheartradio.ihearttrivia.gameplay.GameplayActivity
import com.iheartradio.ihearttrivia.gameplay.GameplayFragment
import io.reactivex.disposables.CompositeDisposable

/**
 * Created by hwang on 8/17/17.
 */
class HomePresenter {
    val homeModel = HomeModel()
    val disposables: CompositeDisposable = CompositeDisposable()
    var activity: Activity? = null
    var homeView: HomeView? = null
    var selectedCategory: Category? = null

    fun bindView(activity: Activity, homeView: HomeView) {
        this.activity = activity
        this.homeView = homeView
        disposables.add(homeView.getOnCategoiesClicked().subscribe({ activity.startActivityForResult<CategoriesActivity>(CategoriesActivity.CATEGORIES_RESULT_CODE) }))
        disposables.add(homeView.getOnGameStartClicked().subscribe({ activity.navigateToActivity<GameplayActivity>(selectedCategory!!.id, GameplayActivity.GAMEPLAY_RESULT_CODE)}))
    }


    fun unbindView() {
        disposables.clear()
    }

    fun onCategoryResult(categoryId: Int) {
        homeModel.getCategoryById(categoryId)
                 .subscribe(
                        {
                            selectedCategory = it
                            homeView?.updateCategoryText(it.name)
                            Toast.makeText(activity, it.name, Toast.LENGTH_SHORT).show()
                        },
                        {})
    }

    fun onGamePlayResult() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}

// inline to indicate it is generic
// reified only works with inline

inline fun <reified T:Activity> Activity.navigateToActivity (categoryId: Int, resultCode: Int) {
    intent = Intent(this, T::class.java)
    intent.putExtra(GameplayFragment.CATEGORY_ID, categoryId)
    startActivityForResult(intent, resultCode)
}

inline fun <reified T:Activity> Activity.startActivityForResult (resultCode:Int) {
    startActivityForResult(Intent(this, T::class.java), resultCode)
}