package com.iheartradio.ihearttrivia.roundsummary

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.iheartradio.ihearttrivia.R
import kotlinx.android.synthetic.main.summary_viewholder.view.*

class SummaryViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(createItem(parent)) {
    
    companion object {
        fun createItem(parent: ViewGroup): View {
            return LayoutInflater.from(parent.context).inflate(R.layout.summary_viewholder, parent, false)
        }
    }

    fun bind(gameResult: GameResult) {
        itemView.item.text = gameResult.question
        itemView.result.isChecked = gameResult.result
    }
}