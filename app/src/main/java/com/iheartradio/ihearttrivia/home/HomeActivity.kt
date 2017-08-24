package com.iheartradio.ihearttrivia.home

import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.AttributeSet
import android.view.View
import com.iheartradio.ihearttrivia.R

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(parent: View?, name: String?, context: Context?, attrs: AttributeSet?): View {
        val v = super.onCreateView(parent, name, context, attrs)
        fragmentManager.beginTransaction().add(HomeFragment(), "homefrag").commit()
        return v
    }
}
