package lat.pam.droidcafe.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import lat.pam.droidcafe.R
import lat.pam.droidcafe.data.UserSession
import lat.pam.droidcafe.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {

    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnLogin.setOnClickListener {
            val username = binding.etUsername.text?.toString()?.trim() ?: ""
            val password = binding.etPassword.text?.toString()?.trim() ?: ""

            if (username.isEmpty() || password.isEmpty()) {
                Toast.makeText(context, getString(R.string.please_fill_fields), Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Set logged in user state
            UserSession.userUsername = username
            if (UserSession.userName.isBlank() || UserSession.userName == "Nama") {
                UserSession.userName = username.replaceFirstChar { it.uppercase() }
            }
            UserSession.isLoggedIn = true

            findNavController().navigate(R.id.action_loginFragment_to_homeFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
