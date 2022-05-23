package tech.cscoder.triviaapp

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.*
import androidx.core.app.ShareCompat
import androidx.fragment.app.Fragment
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
        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.winner_menu, menu)
        if(null == getShareIntent().resolveActivity(requireActivity().packageManager)) {
            menu.findItem(R.id.share).isVisible = false
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.share -> shareSuccess()
        }
        return super.onOptionsItemSelected(item)
    }

    @SuppressLint("StringFormatInvalid")
    private fun getShareIntent() : Intent {
        var args = SuccessFragmentArgs.fromBundle(requireArguments())
        val data = args.numCorrect
        val shareIntent = Intent(Intent.ACTION_SEND)
        shareIntent.setType("text/plain")
            .putExtra(Intent.EXTRA_TEXT, getString(R.string.share_success_text, args.numCorrect, args.numQuestions))
        return shareIntent
    }

    @SuppressLint("StringFormatInvalid")
    private fun getShareCompactIntent() : Intent {
        var args = SuccessFragmentArgs.fromBundle(requireArguments())
        return ShareCompat.IntentBuilder(requireActivity())
            .setText(getString(R.string.share_success_text, args.numQuestions, args.numCorrect))
            .setText("text/plain")
            .intent
    }

    private fun shareSuccess() {
        startActivity(getShareIntent())
    }
}