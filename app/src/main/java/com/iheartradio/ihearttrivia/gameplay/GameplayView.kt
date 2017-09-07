package com.iheartradio.ihearttrivia.gameplay

import android.os.CountDownTimer
import android.view.View
import android.widget.TextView

import com.iheartradio.ihearttrivia.R

import io.reactivex.Observable
import io.reactivex.subjects.PublishSubject

/**
 * Created by sergioteran on 8/24/17.
 */

class GameplayView(val view : View) {
    private val mRoot : View = view
    var mWordTextView : TextView = mRoot.findViewById(R.id.word)
    var mSecRemaining : TextView = mRoot.findViewById(R.id.timer)



    private val mOnClick : PublishSubject<Unit> = PublishSubject.create()
    private val mOnWordChanged : PublishSubject<Unit> = PublishSubject.create()



    init {
        mWordTextView.setOnClickListener { mOnClick.onNext(Unit) }
    }

    fun setWord(word : String) {
        mWordTextView.text = word
        mOnWordChanged.onNext(Unit)
    }

    fun showGameOverMessage(word : String) {
        mWordTextView.text = word;
    }

    fun updateTimer(sec : String) {
        mSecRemaining.text = sec + "sec remaning"
    }

    fun onClickChanged() : Observable<Unit> {
        return mOnClick
    }

    fun onWordChanged() : Observable<Unit> {
        return mOnWordChanged
    }

    fun rootView() : View {
        return mRoot
    }
}