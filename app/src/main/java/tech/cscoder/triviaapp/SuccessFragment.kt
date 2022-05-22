package tech.cscoder.triviaapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import tech.cscoder.triviaapp.databinding.FragmentSuccessBinding

class SuccessFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentSuccessBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_success, container, false)
        binding.nextMatchButton.setOnClickListener { view:View -> view.findNavController().navigate(R.id.action_titleFragment3_to_gameFragment) }
        return binding.root
    }
}