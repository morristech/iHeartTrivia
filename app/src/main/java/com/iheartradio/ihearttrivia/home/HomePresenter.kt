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
    private lateinit var activity: Activity
    private lateinit var homeView: HomeView
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
        if(intent.hasExtra(GameplayActivity.GAMEPLAY_RESULT_DATA)) {
            //Toast.makeText(activity, intent.getStringArrayExtra(GameplayActivity.GAMEPLAY_RESULT_DATA).toString(), Toast.LENGTH_LONG).show()
        }
//        activity.navigateToActivity<RoundSummaryActivity>(ROUND_SUMMARY_DATA_CODE, {
//            putExtra(ROUND_SUMMARY_DATA, "")})
        homeView.updateTeamAScore(10)
        homeView.updateTeamBScore(20)
        //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}

// inline to indicate it is generic
// reified only works with inline

inline fun <reified T:Activity> Activity.navigateToActivity (requestCode: Int, intentAction:Intent.() -> Unit) {
    intent = Intent(this, T::class.java)
    intent.intentAction()
    startActivityForResult(intent, requestCode)
}

inline fun Activity.createResult (resultCode: Int, intentAction:Intent.() -> Unit) {
    intent = Intent()
    intent.intentAction()
    setResult(resultCode, intent)
}

inline fun <reified T:Activity> Activity.startActivityForResult (resultCode:Int) {
    startActivityForResult(Intent(this, T::class.java), resultCode)
}