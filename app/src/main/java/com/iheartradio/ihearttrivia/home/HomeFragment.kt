package com.iheartradio.ihearttrivia.home

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.iheartradio.ihearttrivia.R

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
}