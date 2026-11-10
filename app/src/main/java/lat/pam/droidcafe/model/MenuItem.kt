package lat.pam.droidcafe.model

data class MenuItem(
    val id: Int,
    val name: String,
    val description: String,
    val price: Double,
    val formattedPrice: String,
    val imageResId: Int,
    val category: String = "Makanan"
)
