package com.iheartradio.ihearttrivia.categories

import android.util.Log
import io.reactivex.disposables.Disposable

class CategoriesPresenter {
    private lateinit var mView: CategoriesView

    private val mModel : CategoriesModel = CategoriesModel()


    private var mDisposable: Disposable? = null

    fun bindView(view: CategoriesView) {
        mView = view

        mModel.categories().subscribe({
            mView.setData(it)
        }, {
            Log.e(javaClass.simpleName, "An Exception was thrown")
        })

        mDisposable = mView.onCategoryClicked().subscribe ({
            Log.e(javaClass.simpleName, it.toString())
            mView.setResult(it.id)
        }, {
            Log.e(javaClass.simpleName, "An Exception was thrown")
        })
    }

    fun unsubscribe() {
        mDisposable?.dispose()
        mDisposable = null
    }

}
