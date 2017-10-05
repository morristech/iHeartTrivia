package com.iheartradio.ihearttrivia.gameplay

import android.app.Activity
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.google.gson.Gson
import com.iheartradio.ihearttrivia.R
import com.iheartradio.ihearttrivia.home.createResult
import java.util.*
import kotlin.concurrent.timerTask

class GameplayActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gameplay)
        Timer().schedule(timerTask {
            createResult(Activity.RESULT_OK) { putExtra(GAMEPLAY_RESULT_DATA, Gson().toJson(list))}
            finish()
        }, 3)
    }

    val list = listOf<Pair<String, Boolean>>(
            "name" to true,
            "name2" to false,
            "name3" to false,
            "name4" to true,
            "name5" to false
    )

    companion object {
        val GAMEPLAY_RESULT_DATA:String = "Gameplay Result Key"
        val GAMEPLAY_RESULT_CODE:Int = 100
    }
}
