package com.iheartradio.ihearttrivia.gameplay

/**
 * Created by sergioteran on 8/24/17.
 */

class GameModel {

    private val words : List<String> = arrayListOf("word1", "word2", "word3")
    private var index : Int = 0

    fun getNextWord(): String {
        if (index >= words.size) {
            index = 0
        }

        return words[index++]
    }
}