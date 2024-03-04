package com.test_1.quizztimetest.utils

import android.app.Activity
import android.content.Context
import android.view.View
import com.h2appi.quizztimetest.views.Question

object Utils {

    const val  QUIZ_DATA ="QuizData"
    const val  LAST_SCORE ="LastScore"
    const val  TOTAL_QUIZZES ="TotalQuizzes"


    fun Context.saveQuizData(score: Int) {
        val sharedPref = this.getSharedPreferences("QuizData", Context.MODE_PRIVATE)
        with(sharedPref.edit()) {
            val totalQuizzes = sharedPref.getInt("TotalQuizzes", 0)
            putInt("TotalQuizzes", totalQuizzes + 1)
            putInt("LastScore", score)
            apply()
        }
    }


    fun Context.clearQuizData() {
        val sharedPref = this.getSharedPreferences("QuizData", Context.MODE_PRIVATE)
        with(sharedPref.edit()) {
            remove("TotalQuizzes")
            remove("LastScore")
            apply()
        }
    }

    fun questions() = listOf(
        Question("What is 1 + 1?", listOf("a = 2", "b = 3", "c = 4"), "a"),
        Question("What is 2 + 2?", listOf("a = 3", "b = 4", "c = 5"), "b"),
        Question("What is 3 + 3?", listOf("a = 5", "b = 6", "c = 7"), "b")
    )

    fun Activity.hideStatusBar(){
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN

    }
}
