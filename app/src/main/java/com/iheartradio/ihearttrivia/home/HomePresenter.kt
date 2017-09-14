package com.iheartradio.ihearttrivia.home

import android.app.Activity
import android.content.Intent
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
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
        disposables.add(homeView.getOnGameStartClicked().subscribe({
            activity.navigateToActivity<GameplayActivity>(GameplayActivity.GAMEPLAY_RESULT_CODE, {
                selectedCategory?.let {
                    putExtra(GameplayFragment.CATEGORY_ID, it.id)
                }
        })}))
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

    fun onGamePlayResult(intent: Intent) {
        //activity.startActivityForResult<>()
        Toast.makeText(activity, intent.getStringExtra(GameplayActivity.GAMEPLAY_RESULT_DATA), Toast.LENGTH_LONG).show()
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}

// inline to indicate it is generic
// reified only works with inline

inline fun <reified T:Activity> Activity.navigateToActivity (resultCode: Int, intentAction:Intent.() -> Unit) {
    intent = Intent(this, T::class.java)
    intent.intentAction()
    startActivityForResult(intent, resultCode)
}

inline fun Activity.createResult (resultCode: Int, intentAction:Intent.() -> Unit) {
    intent = Intent()
    intent.intentAction()
    setResult(resultCode, intent)
}

inline fun <reified T:Activity> Activity.startActivityForResult (resultCode:Int) {
    startActivityForResult(Intent(this, T::class.java), resultCode)
}