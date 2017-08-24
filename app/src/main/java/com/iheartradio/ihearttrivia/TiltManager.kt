package com.iheartradio.ihearttrivia

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.util.Log

import io.reactivex.Observable
import io.reactivex.subjects.PublishSubject

/**
 * Created by sergioteran on 8/24/17.
 */
class TiltManager(context : Context) : SensorEventListener {

    private val TAG : String = "TiltManager"

    private val mSubject : PublishSubject<String> = PublishSubject.create()

    private val mSensorManager : SensorManager = context.getSystemService(Context.SENSOR_SERVICE) as SensorManager

    override fun onAccuracyChanged(p0: Sensor?, p1: Int) {
        Log.d(TAG, "AccuracyChanged:  " + p1)
        mSubject.onNext("onAccuracyChanged")
    }

    override fun onSensorChanged(p0: SensorEvent?) {
        Log.d(TAG, "SensorChanged")
        mSubject.onNext("onSensorChanged")
    }

    fun onTiltChanged() : Observable<String> {
        return mSubject
    }

    fun register() {
        mSensorManager.registerListener(this,
                mSensorManager.getDefaultSensor(Sensor.TYPE_LIGHT),
                SensorManager.SENSOR_DELAY_NORMAL)
    }

    fun unregister() {
        mSensorManager.unregisterListener(this)
    }
}