package lat.pam.droidcafe.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import lat.pam.droidcafe.R
import lat.pam.droidcafe.databinding.FragmentSignUpEntryBinding

class SignUpEntryFragment : Fragment() {

    private var _binding: FragmentSignUpEntryBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSignUpEntryBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnGoRegister.setOnClickListener {
            findNavController().navigate(R.id.action_signUpEntryFragment_to_registerFragment)
        }

        binding.btnGoLogin.setOnClickListener {
            findNavController().navigate(R.id.action_signUpEntryFragment_to_loginFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
