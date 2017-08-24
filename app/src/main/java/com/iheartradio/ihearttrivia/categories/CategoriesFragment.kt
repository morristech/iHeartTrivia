package com.iheartradio.ihearttrivia.categories

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
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
        mView.onCategoryClicked().subscribe({
            val intent = Intent()
            intent.putExtra(CATEGORY_KEY, it)
            activity.setResult(CategoriesActivity.CATEGORIES_RESULT_CODE, intent)
            activity.finish()
        },
                { Log.e(javaClass.simpleName, "An Exception was thrown") })

    }

    override fun onStop() {
        super.onStop()
    }

    companion object {
        val CATEGORY_KEY = "category_key"
    }
}

