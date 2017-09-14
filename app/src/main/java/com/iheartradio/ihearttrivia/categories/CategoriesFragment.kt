package com.iheartradio.ihearttrivia.categories

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class CategoriesFragment : Fragment() {
    private lateinit var mView : CategoriesView
    private lateinit var mPresenter : CategoriesPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mPresenter = CategoriesPresenter()
    }

    override fun onCreateView(inflater: LayoutInflater?,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        if (inflater == null || container == null) {
            throw IllegalStateException("Dont give me nulls")
        }
        mView = CategoriesView(inflater, container, activity)
        return mView.mRoot
    }

    override fun onStart() {
        super.onStart()
        mPresenter.bindView(mView)
    }

    override fun onStop() {
        super.onStop()
    }

    companion object {
        val CATEGORY_ID = "category_id"
    }
}

