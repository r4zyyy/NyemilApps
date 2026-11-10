package lat.pam.droidcafe.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import lat.pam.droidcafe.R
import lat.pam.droidcafe.data.UserSession
import lat.pam.droidcafe.databinding.FragmentProfileBinding

class ProfileFragment : Fragment() {

    private var _binding: FragmentProfileBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        updateUi()

        binding.btnSave.setOnClickListener {
            val newName = binding.etName.text?.toString()?.trim() ?: ""
            if (newName.isNotEmpty()) {
                UserSession.userName = newName
                Toast.makeText(context, getString(R.string.profile_updated), Toast.LENGTH_SHORT).show()
                updateUi()
            } else {
                Toast.makeText(context, getString(R.string.please_fill_fields), Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun updateUi() {
        binding.tvGreeting.text = getString(R.string.greeting_user, UserSession.getDisplayName())
        binding.etName.setText(UserSession.userName)
    }

    override fun onResume() {
        super.onResume()
        updateUi()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
