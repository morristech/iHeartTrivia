package com.iheartradio.ihearttrivia.roundsummary

import android.os.Parcel
import android.os.Parcelable
import android.support.v7.widget.RecyclerView
import android.view.ViewGroup

/**
 * Created by hwang on 9/14/17.
 */
class RoundSummaryViewAdapter : RecyclerView.Adapter<SummaryViewHolder>() {
    var mData: List<GameResult> = arrayListOf()

    override fun getItemCount(): Int {
        return mData.size
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): SummaryViewHolder {
        return SummaryViewHolder(parent!!)
    }

    override fun onBindViewHolder(holder: SummaryViewHolder, position: Int) {
        holder.bind(mData[position])
    }
}

data class GameResult(val question: String, val result: Boolean) : Parcelable {
    constructor(parcel: Parcel) : this(
            parcel.readString(),
            parcel.readByte() != 0.toByte())

    override fun writeToParcel(p0: Parcel?, p1: Int) {
        p0?.writeString(question)
        p0?.writeBooleanArray(booleanArrayOf(result))
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<GameResult> {
        override fun createFromParcel(parcel: Parcel): GameResult {
            return GameResult(parcel)
        }

        override fun newArray(size: Int): Array<GameResult?> {
            return arrayOfNulls(size)
        }
    }
}



