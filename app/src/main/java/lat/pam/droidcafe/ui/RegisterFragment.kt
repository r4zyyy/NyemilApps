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
import lat.pam.droidcafe.databinding.FragmentRegisterBinding

class RegisterFragment : Fragment() {

    private var _binding: FragmentRegisterBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRegisterBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnRegister.setOnClickListener {
            val fullName = binding.etFullName.text?.toString()?.trim() ?: ""
            val username = binding.etUsername.text?.toString()?.trim() ?: ""
            val password = binding.etPassword.text?.toString()?.trim() ?: ""

            if (fullName.isEmpty() || username.isEmpty() || password.isEmpty()) {
                Toast.makeText(context, getString(R.string.please_fill_fields), Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            UserSession.userName = fullName
            UserSession.userUsername = username
            UserSession.isLoggedIn = true

            Toast.makeText(context, "Registrasi berhasil! Silakan login.", Toast.LENGTH_SHORT).show()
            findNavController().navigate(R.id.action_registerFragment_to_loginFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
