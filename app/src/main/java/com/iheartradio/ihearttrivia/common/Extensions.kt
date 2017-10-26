package com.iheartradio.ihearttrivia.common

import android.os.Bundle
import android.support.annotation.IdRes
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import com.iheartradio.ihearttrivia.R

inline fun <reified T : Fragment> AppCompatActivity.instantiateFragments (
        bundle: Bundle? = null,
        @IdRes layoutId: Int = R.id.content) : Fragment? {

    val fragment = Fragment.instantiate(this, T::class.simpleName, bundle)

    supportFragmentManager
            .beginTransaction()
            .add(layoutId, fragment).commit()
    return fragment as T
}