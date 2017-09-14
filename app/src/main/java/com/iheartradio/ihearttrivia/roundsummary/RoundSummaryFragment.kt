package com.iheartradio.ihearttrivia.roundsummary

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * Created by hwang on 9/14/17.
 */
class RoundSummaryFragment: Fragment() {

    private val mPresenter:RoundSummaryPresenter = RoundSummaryPresenter()
    private val mView:RoundSummaryView = RoundSummaryView()

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        mView.init(container!!, LayoutInflater.from(context))
        mPresenter.bindView(mView)
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onPause() {
        super.onPause()
    }

    override fun onResume() {
        super.onResume()
    }
}