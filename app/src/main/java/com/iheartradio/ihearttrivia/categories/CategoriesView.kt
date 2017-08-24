package com.iheartradio.ihearttrivia.categories

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.iheartradio.ihearttrivia.R
import com.iheartradio.ihearttrivia.common.Category
import io.reactivex.Observable

class CategoriesView(inflater: LayoutInflater, container: ViewGroup, val activity: Activity) {

    companion object {
        const val RESULT_DATA = "RESULT_DATA"
    }

    val mRoot: View = inflater.inflate(R.layout.catogories_view, container, false)

    private val mCategoryList: RecyclerView
    private val mAdapter: CategoriesListAdapter

    init {
        mCategoryList = mRoot.findViewById<RecyclerView>(R.id.recyclerView)
        mAdapter = CategoriesListAdapter()
        mCategoryList.layoutManager = LinearLayoutManager(mRoot.context)
        mCategoryList.adapter = mAdapter
    }

    fun setData(categories : List<Category>) {
        mAdapter.setData(categories)
    }

    fun setResult(categoryId: Int) {
        val intent = Intent()
        intent.putExtra(RESULT_DATA, categoryId)
        activity.setResult(Activity.RESULT_OK, intent)
    }

    fun onCategoryClicked() : Observable<Category> {
        return mAdapter.onCategoryClicked()
    }

    fun getContext(): Context? {
        return mRoot.context
    }
}

