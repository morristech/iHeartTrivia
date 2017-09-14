package com.iheartradio.ihearttrivia.roundsummary

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.iheartradio.ihearttrivia.R

/**
 * Created by hwang on 9/14/17.
 */
class RoundSummaryView {

    private lateinit var mRecyclerview:RecyclerView
    fun init(view: ViewGroup, inflater: LayoutInflater) {
        var v = inflater.inflate(R.layout.round_summary_list, view, false)
        mRecyclerview = v.findViewById(R.id.recyclerView)
        mRecyclerview.adapter
    }

    fun bind() {

    }
}