package com.iheartradio.ihearttrivia.roundsummary

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.iheartradio.ihearttrivia.R

class RoundSummaryFragment: Fragment() {

    private lateinit var mPresenter:RoundSummaryPresenter

    private val mView:RoundSummaryView = RoundSummaryView()

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        mPresenter = RoundSummaryPresenter(data = arguments.getParcelableArrayList(getString(R.string.GAME_RESULT)))

        mView.init(container!!, LayoutInflater.from(context))

        mPresenter.bindView(mView)

        return super.onCreateView(inflater, container, savedInstanceState)
    }

}