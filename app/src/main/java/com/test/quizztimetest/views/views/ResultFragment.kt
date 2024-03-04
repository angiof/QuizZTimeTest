package com.test.quizztimetest.views.views

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.h2appi.quizztimetest.R
import com.h2appi.quizztimetest.databinding.FragmentResultBinding
import com.test.quizztimetest.views.utils.Utils.LAST_SCORE
import com.test.quizztimetest.views.utils.Utils.QUIZ_DATA
import com.test.quizztimetest.views.utils.Utils.TOTAL_QUIZZES
import com.h2appi.quizztimetest.views.QuizViewModel

class ResultFragment : Fragment() {
    private lateinit var binding: FragmentResultBinding
    private lateinit var viewModel: QuizViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = FragmentResultBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(requireActivity())[QuizViewModel::class.java]

        val sharedPref = requireActivity().getSharedPreferences(QUIZ_DATA, Context.MODE_PRIVATE)
        val totalQuizzes = sharedPref.getInt(TOTAL_QUIZZES, 0) + 1


        with(sharedPref.edit()) {
            putInt(TOTAL_QUIZZES, totalQuizzes)
            putInt(LAST_SCORE, viewModel.score)
            apply()
        }

        binding.scoreTextView.text = getString(R.string.your_score, viewModel.score)
        binding.totalQuizzesTextView.text = getString(R.string.total_quizzes_taken, totalQuizzes)

        binding.retryButton.setOnClickListener {
            viewModel.score = 0
            findNavController().navigate(R.id.quizFragment)
        }

        return binding.root
    }
}

