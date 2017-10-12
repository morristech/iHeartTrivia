package com.iheartradio.ihearttrivia.roundsummary

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.iheartradio.ihearttrivia.R
import com.iheartradio.ihearttrivia.common.instantiateFragments

class RoundSummaryActivity : AppCompatActivity() {

    private val RESULT_KEY: String = "result_todo"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_round_summary)

        if (savedInstanceState!=null) {
            instantiateFragments<RoundSummaryFragment>(intent.getBundleExtra(RESULT_KEY))
        }
    }
}
