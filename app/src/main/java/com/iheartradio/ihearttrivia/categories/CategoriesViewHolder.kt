package com.iheartradio.ihearttrivia.categories

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.iheartradio.ihearttrivia.R
import com.iheartradio.ihearttrivia.common.Category

class CategoriesViewHolder(val parent : ViewGroup,
                           val inflater : LayoutInflater = LayoutInflater.from(parent.context),
                           mRoot : View = inflater.inflate(R.layout.list_item_category, parent, false))
    : RecyclerView.ViewHolder(mRoot) {

    private val mTextView: TextView = mRoot.findViewById<TextView>(R.id.title)


    fun bind(category: Category, onClickAction : () -> Unit) {
        mTextView.text = category.name
        itemView.setOnClickListener {
            onClickAction.invoke()
        }
    }

}