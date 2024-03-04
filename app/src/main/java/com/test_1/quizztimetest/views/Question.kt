package com.h2appi.quizztimetest.views

data class Question(
    val text: String,
    val answers: List<String>,
    val correctAnswer: String
)

