package com.iheartradio.ihearttrivia.gameplay

import android.view.View
import android.widget.TextView
import com.iheartradio.ihearttrivia.R
import io.reactivex.Observable
import io.reactivex.subjects.PublishSubject
import kotlinx.android.synthetic.main.gameplay_layout.view.*

/**
 * Created by sergioteran on 8/24/17.
 */
class GameplayView(val view : View) {
    private val mRoot : View = view
    var mWordTextView : TextView = mRoot.findViewById(R.id.word)

    val mOnClick : PublishSubject<Unit> = PublishSubject.create()

    init {
        mWordTextView.setOnClickListener { mOnClick.onNext(Unit) }
    }

    fun setWord(word : String) {
        mWordTextView.text = word
    }

    fun onClickChanged() : Observable<Unit> {
        return mOnClick
    }

    fun rootView() : View {
        return mRoot
    }


}