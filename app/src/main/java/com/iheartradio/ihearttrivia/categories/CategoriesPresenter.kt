package com.iheartradio.ihearttrivia.categories

import android.util.Log
import android.widget.Toast
import io.reactivex.disposables.Disposable

class CategoriesPresenter() {
    private lateinit var mView: CategoriesView

    private val mModel : CategoriesModel = CategoriesModel()


    private var mDisposable: Disposable? = null

    fun bindView(view: CategoriesView) {
        mView = view
        mView.setData(mModel.data)
        mDisposable = mView.onCategoryClicked().subscribe ({
            Toast.makeText(mView.getContext(), it, Toast.LENGTH_LONG).show() },
                { Log.e(javaClass.simpleName, "An Exception was thrown")})
    }

    fun unsubscribe() {
        mDisposable?.dispose()
        mDisposable = null
    }

}
