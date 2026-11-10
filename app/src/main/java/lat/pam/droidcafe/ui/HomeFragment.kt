package lat.pam.droidcafe.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import lat.pam.droidcafe.R
import lat.pam.droidcafe.adapter.MenuAdapter
import lat.pam.droidcafe.data.CartManager
import lat.pam.droidcafe.data.UserSession
import lat.pam.droidcafe.databinding.FragmentHomeBinding
import lat.pam.droidcafe.model.MenuItem

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.tvGreeting.text = getString(R.string.greeting_user, UserSession.getDisplayName())

        val menuItems = listOf(
            MenuItem(
                id = 1,
                name = "Kopi Rasa Gula Aren",
                description = "Espresso, susu, gula aren",
                price = 22000.0,
                formattedPrice = "Rp 22.000",
                imageResId = R.drawable.img_gula_aren
            ),
            MenuItem(
                id = 2,
                name = "Donat Cokelat",
                description = "Donat empuk, glass cokelat",
                price = 12000.0,
                formattedPrice = "Rp 12.000",
                imageResId = R.drawable.img_donat
            ),
            MenuItem(
                id = 3,
                name = "Sourdough Loaf",
                description = "Roti fermentasi alami",
                price = 35000.0,
                formattedPrice = "Rp 35.000",
                imageResId = R.drawable.img_sourdough
            ),
            MenuItem(
                id = 4,
                name = "Cappuccino",
                description = "Espresso, foam susu terbuat",
                price = 28000.0,
                formattedPrice = "Rp 28.000",
                imageResId = R.drawable.img_cappuccino
            ),
            MenuItem(
                id = 5,
                name = "Matcha Latte",
                description = "Matcha jepang, susu segar",
                price = 27000.0,
                formattedPrice = "Rp 27.000",
                imageResId = R.drawable.img_matcha
            )
        )

        val adapter = MenuAdapter(menuItems) { selectedItem ->
            CartManager.addItem(selectedItem)
            Toast.makeText(
                context,
                "${selectedItem.name} ${getString(R.string.added_to_cart)}",
                Toast.LENGTH_SHORT
            ).show()
        }

        binding.rvMenu.adapter = adapter
    }

    override fun onResume() {
        super.onResume()
        binding.tvGreeting.text = getString(R.string.greeting_user, UserSession.getDisplayName())
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
