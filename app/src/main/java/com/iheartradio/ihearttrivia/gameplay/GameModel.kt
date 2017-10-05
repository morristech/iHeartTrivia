package com.iheartradio.ihearttrivia.gameplay

/**
 * Created by sergioteran on 8/24/17.
 */

class GameModel {

    private val words : List<String> = arrayListOf("word0", "word1", "word2")
    private var index : Int = 0
    private var score : Int = 0;

    fun getCurrentWord(): String {


        if(isFinish()) {
            index = words.size -1
        }

        val s =  words[index]
        index++;

        return s;
    }

    fun isFinish() : Boolean {
        return index >= words.size
    }

    fun score() {
        score++
    }

    fun getScore() : Int {
        return score
    }
}