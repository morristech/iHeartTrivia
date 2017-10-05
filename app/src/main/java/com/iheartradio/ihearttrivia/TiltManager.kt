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

    enum class Tilt {
        TILT_UP,
        TILT_DOWN
    }

    private val TAG : String = "TiltManager"

    private val mSubject : PublishSubject<Tilt> = PublishSubject.create()

    private val mSensorManager : SensorManager = context.getSystemService(Context.SENSOR_SERVICE) as SensorManager

    private var mTilt = false
    private var mLastX = 0F
    private var mLastZ = 0F


    override fun onAccuracyChanged(p0: Sensor?, p1: Int) {
        Log.d(TAG, "AccuracyChanged:  " + p1)
    }

    override fun onSensorChanged(p0: SensorEvent?) {
        if (p0!!.sensor.type == Sensor.TYPE_ACCELEROMETER) {

            //var incomingX = p0.values[0]
            //var incomingY = p0.values[1]
            var incomingZ = p0.values[2]

/*            //var deltaX = incomingX - mLastX;
            var deltaZ = incomingZ - mLastZ;

            //Log.d(TAG, "incomingZ : $incomingZ")

            if(mTilt && deltaZ > - 6) {
                mSubject.onNext("tilt down : " + incomingZ)
                mTilt = false
            } else if (mTilt && deltaZ > 6){
                mSubject.onNext("tilt up : " + incomingZ)
                mTilt = false

            }  else if (incomingZ > -1 && incomingZ < 1){
                mTilt = true
            }*/

            if( incomingZ > 7) {

                if (!mTilt) {
                    mSubject.onNext(Tilt.TILT_UP)
                    mTilt = true
                }

            } else if (incomingZ < -7) {
                if (!mTilt) {
                    mSubject.onNext(Tilt.TILT_DOWN)
                    mTilt = true
                }

            } else if (incomingZ > -1 && incomingZ < 1){
                mTilt = false
            }

   /*         if (!mTilt && deltaX < -3 ) {

                Log.d(TAG, "tilt happened")

                mTilt = true;
                mLastX = incomingX
                mLastZ = incomingZ
                return
            }

            if (mTilt &&  deltaX > 3) {

                mTilt = false;
                mLastX = incomingX
                mLastZ = incomingZ

                Log.d(TAG, "VALUE: " + (incomingX - mLastX));

                Log.d(TAG, "time to change")

                if (deltaZ > 3) {
                    mSubject.onNext("tilt up")
                } else {
                    mSubject.onNext("tilt down")
                }


            }*/
        }
    }

    fun onTiltChanged() : Observable<Tilt> {
        return mSubject
    }

    fun register() {
        mSensorManager.registerListener(this,
                mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER),
                SensorManager.SENSOR_DELAY_NORMAL)
    }

    fun unregister() {
        mSensorManager.unregisterListener(this)
    }
}