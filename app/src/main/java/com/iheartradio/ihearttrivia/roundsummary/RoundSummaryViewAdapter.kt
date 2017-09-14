package com.iheartradio.ihearttrivia.roundsummary

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup

/**
 * Created by hwang on 9/14/17.
 */
class RoundSummaryViewAdapter : RecyclerView.Adapter<SummaryViewHolder>() {
    var mData: ArrayList<GameResult> = arrayListOf()

    override fun getItemCount(): Int {
        return mData.size
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): SummaryViewHolder {
        return SummaryViewHolder(parent!!)
    }

    override fun onBindViewHolder(holder: SummaryViewHolder, position: Int) {
        holder.bind(mData[position])
    }
}

data class GameResult(val question: String, val result: Boolean)



