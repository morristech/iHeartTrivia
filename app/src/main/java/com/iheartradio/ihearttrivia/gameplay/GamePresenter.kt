package com.iheartradio.ihearttrivia.gameplay

import com.iheartradio.ihearttrivia.TiltManager
import io.reactivex.disposables.CompositeDisposable

/**
 * Created by sergioteran on 8/24/17.
 */
class GamePresenter {

    private val mModel : GameModel = GameModel()
    private lateinit var mView : GameplayView
    private val mDisposables : CompositeDisposable = CompositeDisposable()

    private lateinit var mTiltManager : TiltManager

    fun bindView(view : GameplayView) {
        mView = view
        mView.setWord(mModel.getNextWord())


        mTiltManager = TiltManager(mView.rootView().context)
        mTiltManager.register()


        mDisposables.add(mTiltManager.onTiltChanged().subscribe({

            mView.setWord(mModel.getNextWord())
        }))
    }

    fun unbind() {
        mTiltManager.unregister()
        mDisposables.clear()
    }
}