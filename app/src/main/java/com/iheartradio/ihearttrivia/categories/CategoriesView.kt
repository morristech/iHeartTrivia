package com.iheartradio.ihearttrivia.categories

import android.content.Context
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.iheartradio.ihearttrivia.R
import io.reactivex.Observable

class CategoriesView(inflater: LayoutInflater, container: ViewGroup) {
    val  mRoot: View
    private val mCategoryList: RecyclerView

    private val  mAdapter: CategoriesListAdapter

    init {
        mRoot = inflater.inflate(R.layout.catogories_view, container, false)
        mCategoryList = mRoot.findViewById<RecyclerView>(R.id.recyclerView)
        mAdapter = CategoriesListAdapter()
        mCategoryList.layoutManager = LinearLayoutManager(mRoot.context)
        mCategoryList.adapter = mAdapter

    }

    fun setData(categorieNames : List<String>) {
        mAdapter.setData(categorieNames)
    }

    fun onCategoryClicked() : Observable<String> {
        return mAdapter.onCategoryClicked()
    }

    fun getContext(): Context? {
        return mRoot.context
    }


}

