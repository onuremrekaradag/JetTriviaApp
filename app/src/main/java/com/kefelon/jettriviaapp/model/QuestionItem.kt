package com.kefelon.jettriviaapp.model

data class QuestionItem(
    val answer: String?,
    val category: String?,
    val choices: List<String?>?,
    val question: String?
)