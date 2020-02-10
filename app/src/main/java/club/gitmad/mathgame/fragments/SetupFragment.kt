package club.gitmad.mathgame.fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController

import club.gitmad.mathgame.R
import kotlinx.android.synthetic.main.fragment_setup.*

class SetupFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_setup, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnStart.setOnClickListener {
            val numQuestions = Integer.parseInt(etNumQuestions.text.toString())

            this.findNavController()
                .navigate(SetupFragmentDirections.actionSetupFragmentToGameFragment(numQuestions))
        }
    }

}
