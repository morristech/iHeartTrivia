package com.iheartradio.ihearttrivia.gameplay

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.iheartradio.ihearttrivia.R

class GameplayActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gameplay)
        var fragment = supportFragmentManager.findFragmentById(R.id.gameplay_container)

        if (fragment == null) {
            fragment = GameplayFragment()
            supportFragmentManager.beginTransaction()
                    .add(R.id.gameplay_container, fragment)
                    .commit()
        }
    }
}
