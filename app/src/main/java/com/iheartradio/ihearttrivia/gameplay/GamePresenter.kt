package com.iheartradio.ihearttrivia.gameplay

import android.os.CountDownTimer
import com.iheartradio.ihearttrivia.TiltManager
import io.reactivex.disposables.CompositeDisposable

/**
 * Created by sergioteran on 8/24/17.
 */
class GamePresenter {

    private val mModel : GameModel = GameModel()
    private lateinit var mView : GameplayView
    private val mDisposables : CompositeDisposable = CompositeDisposable()

    private val mCounterTimer = object: CountDownTimer(5000, 1000){
        override fun onFinish() {
            if(!mModel.isFinish()) {
                mView.setWord(mModel.getCurrentWord())
            } else {
                mView.showGameOverMessage("Game Over");
            }
        }

        override fun onTick(secInMill: Long) {
            mView.updateTimer((secInMill/1000).toString())
        }
    }

    private lateinit var mTiltManager : TiltManager

    fun bindView(view : GameplayView) {
        mView = view
        mView.onWordChanged()
                .subscribe({ startTimer()})

        mView.setWord(mModel.getCurrentWord())

        mTiltManager = TiltManager(mView.rootView().context)
        mTiltManager.register()


        mDisposables.add(mTiltManager.onTiltChanged().subscribe({

            mView.setWord(mModel.getCurrentWord())
        }))


    }



    fun startTimer() {
        mCounterTimer.cancel();
        mCounterTimer.start();
    }

    fun unbind() {
        mTiltManager.unregister()
        mDisposables.clear()
    }
}