package lat.pam.droidcafe.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import lat.pam.droidcafe.R
import lat.pam.droidcafe.data.CartManager
import lat.pam.droidcafe.data.UserSession
import lat.pam.droidcafe.databinding.FragmentConfirmationBinding

class ConfirmationFragment : Fragment() {

    private var _binding: FragmentConfirmationBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentConfirmationBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val displayName = if (CartManager.recipientName.isNotBlank()) {
            CartManager.recipientName
        } else {
            UserSession.getDisplayName()
        }

        binding.tvGreeting.text = getString(R.string.greeting_user, displayName)

        binding.btnOke.setOnClickListener {
            CartManager.clear()
            findNavController().navigate(R.id.action_confirmationFragment_to_homeFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
