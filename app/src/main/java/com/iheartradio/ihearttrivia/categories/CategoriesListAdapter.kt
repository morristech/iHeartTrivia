package com.iheartradio.ihearttrivia.categories

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import com.iheartradio.ihearttrivia.common.Category
import io.reactivex.subjects.PublishSubject

class CategoriesListAdapter(var categorieNames: List<Category> = emptyList())
    : RecyclerView.Adapter<CategoriesViewHolder>() {

    private val mOnClicked: PublishSubject<Category> = PublishSubject.create()

    fun setData(data: List<Category>) {
        categorieNames = data
        notifyDataSetChanged()
    }

    fun onCategoryClicked() = mOnClicked

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): CategoriesViewHolder {
        if (parent == null) {
            throw IllegalStateException("Dont pass null")
        }
        return CategoriesViewHolder(parent)
    }

    override fun onBindViewHolder(holder: CategoriesViewHolder, position: Int) {
        val data : Category = categorieNames[position]
        holder.bind(data, { mOnClicked.onNext(data) })
    }

    override fun getItemCount() = categorieNames.size

}

