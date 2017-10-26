package com.iheartradio.ihearttrivia.gameplay

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.iheartradio.ihearttrivia.R
import com.iheartradio.ihearttrivia.home.createResult
import java.util.*
import kotlin.concurrent.timerTask

class GameplayActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gameplay)

//        var fragment = supportFragmentManager.findFragmentById(R.id.gameplay_container)
//
//        if (fragment == null) {
//            fragment = GameplayFragment()
//            supportFragmentManager.beginTransaction()
//                    .add(R.id.gameplay_container, fragment)
//                    .commit()
//        }

        Timer().schedule(timerTask {
            createResult(GAMEPLAY_RESULT_CODE) { putStringArrayListExtra(GAMEPLAY_RESULT_DATA, list2)}
            finish()
        }, 3)
    }

//    val list = arrayListOf<GameResult>(
//            GameResult("name1", true),
//            GameResult("name2", false),
//            GameResult("name3", false),
//            GameResult("name4", true),
//            GameResult("name5", false)
//    )

    val list2 = arrayListOf<String>(
            "frfsd", "fasdf")

    companion object {
        val GAMEPLAY_RESULT_DATA:String = "Gameplay Result Key"
        val GAMEPLAY_RESULT_CODE:Int = 100
    }
}