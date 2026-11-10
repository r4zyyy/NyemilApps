package lat.pam.droidcafe.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import lat.pam.droidcafe.R
import lat.pam.droidcafe.data.CartManager
import lat.pam.droidcafe.data.UserSession
import lat.pam.droidcafe.databinding.FragmentAddressBinding
import java.text.NumberFormat
import java.util.Locale

class AddressFragment : Fragment() {

    private var _binding: FragmentAddressBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAddressBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Pre-fill recipient name if user logged in
        binding.etRecipientName.setText(UserSession.getDisplayName())

        updateSummary()

        binding.btnOrderKirim.setOnClickListener {
            val name = binding.etRecipientName.text?.toString()?.trim() ?: ""
            val address = binding.etAddress.text?.toString()?.trim() ?: ""
            val benchmark = binding.etBenchmark.text?.toString()?.trim() ?: ""

            if (name.isEmpty() || address.isEmpty()) {
                Toast.makeText(context, getString(R.string.please_fill_fields), Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            CartManager.recipientName = name
            CartManager.deliveryAddress = address
            CartManager.addressBenchmark = benchmark

            findNavController().navigate(R.id.action_addressFragment_to_confirmationFragment)
        }
    }

    private fun updateSummary() {
        val items = CartManager.getItems()
        val total = CartManager.getTotalPrice()
        val localeID = Locale.Builder().setLanguage("id").setRegion("ID").build()
        val format = NumberFormat.getCurrencyInstance(localeID)
        val formattedTotal = format.format(total).replace(",00", "")

        binding.tvOrderSummary.text = if (items.isNotEmpty()) {
            "Item dipesan: ${items.size} item | Total: $formattedTotal"
        } else {
            getString(R.string.no_item_selected)
        }
    }

    override fun onResume() {
        super.onResume()
        updateSummary()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
