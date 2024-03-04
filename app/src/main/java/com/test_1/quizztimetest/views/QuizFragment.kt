package com.test_1.quizztimetest.views

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.h2appi.quizztimetest.R
import com.h2appi.quizztimetest.databinding.FragmentQuizBinding
import com.test_1.quizztimetest.utils.Utils
import com.h2appi.quizztimetest.views.QuizViewModel
import java.util.Locale

class QuizFragment : Fragment() {
    private lateinit var binding: FragmentQuizBinding
    private lateinit var viewModel: QuizViewModel

    private var currentQuestionIndex = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentQuizBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(requireActivity())[QuizViewModel::class.java]

        showQuestion()

        with(binding) {
            submitAnswerButton.setOnClickListener {
                checkAnswer()
                showNextQuestion()
            }
        }

        return binding.root
    }

    private fun showQuestion() {
        val currentQuestion = Utils.questions()[currentQuestionIndex]
        binding.questionTextView.text = currentQuestion.text
        binding.tvPossibileRsp.text = currentQuestion.answers.joinToString("\n")
    }

    private fun checkAnswer() {
        val userAnswer = binding.answerEditText.text.toString().trim().lowercase(Locale.ROOT)
        if (userAnswer == Utils.questions()[currentQuestionIndex].correctAnswer) {
            viewModel.score++
            Log.d("QuizFragment", "Score incrementato a: ${viewModel.score}")
        } else {
            Log.d("QuizFragment", "Risposta sbagliata. Score: ${viewModel.score}")
        }
        binding.answerEditText.setText("")
    }

    private fun showNextQuestion() {
        currentQuestionIndex++
        if (currentQuestionIndex < Utils.questions().size) {
            showQuestion()
        } else {
            showResults()
        }
    }


    private fun showResults() {
        findNavController().navigate(R.id.resultFragment)
    }
}
