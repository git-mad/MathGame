package club.gitmad.mathgame.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs

import club.gitmad.mathgame.R
import kotlinx.android.synthetic.main.fragment_game.*

class GameFragment : Fragment() {

    private var numQuestions = 0
    private var numCorrect = 0
    private var currQuestion = 0
    private var startTime = System.currentTimeMillis()
    private val args: GameFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_game, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        numQuestions = args.numQuestions

        setQuestion()
    }

    private fun setQuestion() {
        tvQuestionNumber.text = "Question: $currQuestion/$numQuestions"

        val firstTerm = (0..10).random()
        val secondTerm = (0..10).random()

        val question = "$firstTerm + $secondTerm"
        tvQuestion.text = question

        btnAnswer.setOnClickListener {
            val userAnswer = Integer.parseInt(etAnswer.text.toString())

            if (firstTerm + secondTerm == userAnswer) {
                Toast.makeText(context, "Correct!", Toast.LENGTH_SHORT).show()
                numCorrect++
            } else {
                Toast.makeText(context, "Incorrect!", Toast.LENGTH_SHORT).show()
            }

            currQuestion++

            if (currQuestion == numQuestions) {
                this.findNavController().navigate(
                    GameFragmentDirections.actionGameFragmentToResultsFragment(
                        numCorrect,
                        numQuestions,
                        System.currentTimeMillis() - startTime
                    )
                )
            }

            etAnswer.setText("")
            setQuestion()
        }
    }
}
