package com.test.quizztimetest.views

import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.view.Gravity
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.navigation.NavInflater
import androidx.navigation.fragment.NavHostFragment
import com.h2appi.quizztimetest.R
import com.h2appi.quizztimetest.databinding.BaseLayoutBinding
import com.test.quizztimetest.views.utils.Utils.clearQuizData
import com.skydoves.powermenu.MenuAnimation
import com.skydoves.powermenu.OnMenuItemClickListener
import com.skydoves.powermenu.PowerMenu
import com.skydoves.powermenu.PowerMenuItem
import com.test.quizztimetest.views.utils.Utils.CLEAR_AND_RESET
import com.test.quizztimetest.views.utils.Utils.CLOSE
import com.test.quizztimetest.views.utils.Utils.RESET_QUIZ

abstract class BaseActivity : AppCompatActivity() {
    abstract var binding: BaseLayoutBinding
    private lateinit var powerMenu: PowerMenu

    lateinit var navHostFragment: NavHostFragment
    lateinit var navInflater: NavInflater


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = BaseLayoutBinding.inflate(layoutInflater)

        setContentView(binding.root)

        navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment_activity_base) as NavHostFragment
        navInflater = navHostFragment.navController.navInflater

        setMenu()


        binding.btnBaseFormClose.setOnClickListener {
            powerMenu.showAsAnchorLeftTop(it)

        }
    }

    private fun setMenu() {
        val onMenuItemClickListener = OnMenuItemClickListener<PowerMenuItem> { position, item ->

            when (position) {
                0 -> {
                    finish()
                }

                1 -> {
                    navHostFragment.navController.navigate(R.id.homeQuizFragment)
                }

                2 -> {
                    clearQuizData()
                    navHostFragment.navController.navigate(R.id.homeQuizFragment)
                }
            }
            powerMenu.dismiss()
        }

        val lista = listOf(
            PowerMenuItem(CLOSE, false),
            PowerMenuItem(RESET_QUIZ, false),
            PowerMenuItem(CLEAR_AND_RESET, false)
        )

        powerMenu = PowerMenu.Builder(this)
            .addItemList(lista)
            .setAnimation(MenuAnimation.SHOWUP_TOP_LEFT)
            .setMenuRadius(10f)
            .setMenuShadow(10f)
            .setTextColor(
                ContextCompat.getColor(
                    this,
                    android.R.color.black
                )
            )
            .setTextGravity(Gravity.CENTER)
            .setTextTypeface(
                Typeface.create(
                    "sans-serif-medium",
                    Typeface.BOLD
                )
            )
            .setSelectedTextColor(Color.WHITE)
            .setMenuColor(Color.WHITE)
            .setSelectedMenuColor(
                ContextCompat.getColor(
                    this,
                    android.R.color.black
                )
            )
            .setOnMenuItemClickListener(onMenuItemClickListener)
            .build()
    }


}

