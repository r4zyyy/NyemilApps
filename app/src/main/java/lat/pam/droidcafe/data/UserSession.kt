package lat.pam.droidcafe.data

object UserSession {
    var userName: String = "Nama"
    var userUsername: String = ""
    var isLoggedIn: Boolean = false

    fun getDisplayName(): String {
        return if (userName.isBlank()) "Nama" else userName
    }
}
