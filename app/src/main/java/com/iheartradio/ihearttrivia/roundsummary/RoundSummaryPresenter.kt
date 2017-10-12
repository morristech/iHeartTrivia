package com.iheartradio.ihearttrivia.roundsummary

/**
 * Created by hwang on 9/14/17.
 */
class RoundSummaryPresenter(val data: List<GameResult>) {

    fun bindView(view: RoundSummaryView) {
        view.bind(data)

    }
}