package com.iheartradio.ihearttrivia.home

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.iheartradio.ihearttrivia.R
import com.iheartradio.ihearttrivia.categories.CategoriesActivity
import com.iheartradio.ihearttrivia.categories.CategoriesFragment

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.frame_layout)
        supportFragmentManager.beginTransaction()
                .add(R.id.content, HomeFragment(), "homefrag")
                .commit()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode == CategoriesActivity.CATEGORIES_RESULT_CODE){
            Toast.makeText(this, data.getStringExtra(CategoriesFragment.CATEGORY_KEY), Toast.LENGTH_LONG).show()
        }
    }
}
