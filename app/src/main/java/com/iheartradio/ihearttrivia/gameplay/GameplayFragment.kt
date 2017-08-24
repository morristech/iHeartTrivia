package com.iheartradio.ihearttrivia.gameplay

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.iheartradio.ihearttrivia.R

/**
 * Created by sergioteran on 8/24/17.
 */
class GameplayFragment : Fragment() {
    private val mPresenter = GamePresenter()

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val view = inflater.inflate(R.layout.gameplay_layout, container, false)

        val gameView = GameplayView(view)
        mPresenter.bindView(gameView)
        return view
    }

    override fun onDestroy() {
        super.onDestroy()
        mPresenter.unbind()
    }
}