package com.iheartradio.ihearttrivia.common

import io.reactivex.rxkotlin.toSingle

class QuestionsApi {

    val colorQuestions = listOf("Red",
            "Blue",
            "Green",
            "Orange",
            "White",
            "Purple",
            "Yellow",
            "Black")

    val cityQuestions = listOf("NYC",
            "Chicago",
            "Tokyo",
            "LA",
            "Paris",
            "Moscow",
            "London",
            "Barcelona")

    val foodQuestions = listOf("Burger",
            "Hotdog",
            "Pizza",
            "Pasta",
            "Sushi",
            "Bagel",
            "Steak",
            "Icecream")

    val natureQuestions = listOf("Mountain",
            "Valley",
            "Sunset",
            "Ocean",
            "Field",
            "River",
            "Waterfall",
            "Cliff")

    val androidTeamQuestions = listOf("Hua",
            "Darien",
            "Jonathan Johnson",
            "Kisik",
            "Sergio",
            "Eric",
            "Sung",
            "Chunan",
            "Colin",
            "Jonathan Muller")

    val questionsMap = mapOf(1 to androidTeamQuestions,
            2 to colorQuestions,
            3 to cityQuestions,
            4 to foodQuestions,
            5 to natureQuestions)

    fun questions(categoryId: Int) = questionsMap.getOrDefault(categoryId, androidTeamQuestions).toSingle()
}