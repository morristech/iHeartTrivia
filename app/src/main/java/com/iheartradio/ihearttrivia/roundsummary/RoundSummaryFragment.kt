package com.iheartradio.ihearttrivia.roundsummary

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.gson.reflect.TypeToken
import com.iheartradio.ihearttrivia.gameplay.GameplayActivity
import com.iheartradio.ihearttrivia.gameplay.listFromJson

open class RoundSummaryFragment: Fragment() {

    private lateinit var mPresenter:RoundSummaryPresenter

    private val mView:RoundSummaryView = RoundSummaryView()

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val resultCode = GameplayActivity.GAMEPLAY_RESULT_DATA
        val data: List<GameResult> = arguments.getString(resultCode).listFromJson<GameResult, List<GameResult>>()

        mPresenter = RoundSummaryPresenter(data)

        mView.init(container!!, LayoutInflater.from(context))

        mPresenter.bindView(mView)

        return super.onCreateView(inflater, container, savedInstanceState)
    }

}
