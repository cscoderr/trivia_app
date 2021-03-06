package tech.cscoder.triviaapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import tech.cscoder.triviaapp.databinding.FragmentFailureBinding

class FailureFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentFailureBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_failure, container, false)
        binding.tryAgainButton.setOnClickListener { view:View -> view.findNavController().navigate(R.id.action_titleFragment3_to_gameFragment) }
        return binding.root
    }
}