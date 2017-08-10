package com.iheartradio.ihearttrivia.categories

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.iheartradio.ihearttrivia.R

class CategoriesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.frame_layout)
        if (savedInstanceState == null ) {
            instantiateFragments()
        }
    }

    fun instantiateFragments() {
        val fragment : CategoriesFragment = CategoriesFragment()
        supportFragmentManager.beginTransaction().add(R.id.content, fragment).commit()
    }
}

