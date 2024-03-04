package com.test_1.quizztimetest.views

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.h2appi.quizztimetest.R
import com.h2appi.quizztimetest.databinding.FragmentHomeQuizBinding
import com.h2appi.quizztimetest.utils.Utils.LAST_SCORE
import com.h2appi.quizztimetest.utils.Utils.QUIZ_DATA
import com.test.quizztimetest.views.MainActivity


class HomeQuizFragment : Fragment() {
    private lateinit var binding: FragmentHomeQuizBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeQuizBinding.inflate(inflater, container, false)

        activity?.let {
            if (it is MainActivity) {
                it.hideFbButton()
            }
        }

        with(binding) {
            this.textView.text = buildString {
                append(getString(R.string.last_score))
                append(getScore().toString())
            }
            this.bntHome.setOnClickListener {
                findNavController().navigate(R.id.quizFragment)
                activity?.let {
                    if (it is MainActivity) {
                        it.showFbButton()
                    }
                }
            }
        }


        return binding.root

    }


    fun getScore(): Int {
        val sharedPref = requireActivity().getSharedPreferences(QUIZ_DATA, Context.MODE_PRIVATE)
        val score = sharedPref.getInt(LAST_SCORE, 0)
        return sharedPref.getInt(LAST_SCORE, 0) + 0

    }

}