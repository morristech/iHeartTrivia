package com.iheartradio.ihearttrivia.home

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.iheartradio.ihearttrivia.R
import com.iheartradio.ihearttrivia.categories.CategoriesActivity
import com.iheartradio.ihearttrivia.categories.CategoriesFragment
import com.iheartradio.ihearttrivia.gameplay.GameplayActivity

/**
 * Created by hwang on 8/17/17.
 */
class HomeFragment : Fragment() {

    private val presenter = HomePresenter()
    private lateinit var view:HomeView


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val v = inflater.inflate(R.layout.activity_main, container, false)
        view = HomeView(v)
        presenter.bindView(activity, view)
        return v
    }

    override fun onDestroyView() {
        super.onDestroyView()
        presenter.unbindView()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        data?.let {
            if (requestCode == CategoriesActivity.CATEGORIES_RESULT_CODE) {
                presenter.onCategoryResult(it.getIntExtra(CategoriesFragment.CATEGORY_ID, -1))
            } else if (requestCode == GameplayActivity.GAMEPLAY_RESULT_CODE) {
                presenter.onGamePlayResult(it)
            }
        }
    }
}