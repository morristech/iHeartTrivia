package com.iheartradio.ihearttrivia.gameplay

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.iheartradio.ihearttrivia.R

class GameplayActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gameplay)
    }

    companion object {
        val GAMEPLAY_RESULT_CODE:Int = 100
    }
}
