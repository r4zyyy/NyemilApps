package lat.pam.droidcafe.data

import lat.pam.droidcafe.model.MenuItem

object CartManager {
    private val cartItems = mutableListOf<MenuItem>()
    var recipientName: String = ""
    var deliveryAddress: String = ""
    var addressBenchmark: String = ""

    fun addItem(item: MenuItem) {
        cartItems.add(item)
    }

    fun getItems(): List<MenuItem> = cartItems

    fun clear() {
        cartItems.clear()
        recipientName = ""
        deliveryAddress = ""
        addressBenchmark = ""
    }

    fun getTotalPrice(): Double = cartItems.sumOf { it.price }

    fun hasItems(): Boolean = cartItems.isNotEmpty()
}
