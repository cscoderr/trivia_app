package tech.cscoder.triviaapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import tech.cscoder.triviaapp.databinding.ActivityMainBinding
import tech.cscoder.triviaapp.databinding.FragmentGameBinding

class GameFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentGameBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_game,container, false)

        binding.submitButton.setOnClickListener { view: View -> view.findNavController().navigate(R.id.action_gameFragment_to_successFragment) }
        binding.failureButton.setOnClickListener { view:View -> view.findNavController().navigate(R.id.action_gameFragment_to_failureFragment) }
        return binding.root;
    }
}