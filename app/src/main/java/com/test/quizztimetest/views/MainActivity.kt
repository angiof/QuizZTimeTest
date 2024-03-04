package com.test.quizztimetest.views

import android.os.Bundle
import android.view.View
import androidx.navigation.NavGraph
import com.h2appi.quizztimetest.databinding.BaseLayoutBinding
import com.test.quizztimetest.views.utils.Utils.hideStatusBar


class MainActivity() : BaseActivity() {

    override lateinit var binding: BaseLayoutBinding
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        hideStatusBar()
        val navController = navHostFragment.navController
        val navGraph: NavGraph = navInflater.inflate(com.h2appi.quizztimetest.R.navigation.nav_base)
        navController.graph = navGraph
        //Ciao Matteo ho finito di farlo adesso ,domani purtroppo saro in ufficio

        fb()
    }


     fun fb() {
        binding.fbM.setOnClickListener {
            navHostFragment.navController
                .navigate(com.h2appi.quizztimetest.R.id.homeQuizFragment)

        }
    }

    fun showFbButton() {
        binding.fbM.visibility = View.VISIBLE
    }

    fun hideFbButton() {
        binding.fbM.visibility = View.GONE
    }


}