package com.iheartradio.ihearttrivia.home

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.iheartradio.ihearttrivia.R

class HomeActivity : AppCompatActivity() {

    var homeFragment : HomeFragment? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.frame_layout)
        homeFragment = HomeFragment()
        supportFragmentManager.beginTransaction()
                .add(R.id.content, homeFragment, "homefrag")
                .commit()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        homeFragment?.onActivityResult(requestCode, resultCode, data)
    }
}
