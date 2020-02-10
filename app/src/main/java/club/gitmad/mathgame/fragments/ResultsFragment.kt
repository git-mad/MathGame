package club.gitmad.mathgame.fragments

import android.content.Context
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs

import club.gitmad.mathgame.R
import kotlinx.android.synthetic.main.fragment_results.*

class ResultsFragment : Fragment() {

    val args: ResultsFragmentArgs by navArgs()
    private var numQuestions = 0
    private var numCorrect = 0
    private var totalTime = 0L

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_results, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        numQuestions = args.numQuestions
        numCorrect = args.numCorrect
        totalTime = args.totalTime

        tvAccuracy.text = "$numCorrect/$numQuestions"
        tvTotalTime.text = "${totalTime / 1000} seconds"

        btnNewGame.setOnClickListener {
            this.findNavController()
                .navigate(ResultsFragmentDirections.actionResultsFragmentToSetupFragment())
        }
    }
}
