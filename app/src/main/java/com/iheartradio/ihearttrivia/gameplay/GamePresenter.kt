package com.iheartradio.ihearttrivia.gameplay

import android.os.CountDownTimer
import android.util.Log
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
           updateView()
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

        updateView()

        mTiltManager = TiltManager(mView.rootView().context)
        mTiltManager.register()


        mDisposables.add(mTiltManager.onTiltChanged()
                .subscribe({
                    tilt ->
                    if (tilt == TiltManager.Tilt.TILT_DOWN) {
                        Log.d("til", "scored one point")

                        if (!mModel.isFinish()) {
                            mModel.score()
                        }

                    } else {
                        Log.d("til", "no point")
                    }

                    updateView()

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

    private fun updateView() {

        if (mModel.isFinish()) {
            mView.showGameOverMessage("Game Over");
        } else {
            mView.setWord(mModel.getCurrentWord())
        }
        mView.updateScore(mModel.getScore())
    }
}