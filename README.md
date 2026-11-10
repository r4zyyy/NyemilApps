# Kopi dan Nyemil ☕🍩 - Application Documentation

Aplikasi mobile **Kopi dan Nyemil** adalah aplikasi pemesanan kopi dan makanan ringan (snack) berbasis Android yang dibangun sesuai spesifikasi wireframe. Aplikasi ini mengusung desain modern Material Design 3 dengan skema warna khas kedai kopi (*coffee warm aesthetic*).

---

## 📋 Daftar Isi
- [Deskripsi Aplikasi](#-deskripsi-aplikasi)
- [Fitur Utama](#-fitur-utama)
- [Teknologi yang Digunakan](#-teknologi-yang-digunakan)
- [Struktur Tampilan Wireframe](#-struktur-tampilan-wireframe)
- [Cara Menjalankan Aplikasi](#-cara-menjalankan-aplikasi)
- [Tampilan Layar (Screenshots)](#-tampilan-layar-screenshots)

---

## ☕ Deskripsi Aplikasi
**Kopi dan Nyemil** mempermudah pelanggan untuk menjelajahi menu kopi pilihan dan kudapan lezat, melakukan pendaftaran akun, mengelola profil, memasukkan alamat pengiriman, serta mengonfirmasi pesanan secara instan.

Sesuai ketentuan tugas:
- Mengimplementasikan seluruh 8 alur tampilan wireframe.
- Menggunakan data statis (*dummy data*) tanpa database eksternal.
- Antarmuka dikembangkan secara modern dan *user-friendly* menggunakan Material 3.
- Menampilkan lebih dari 5 item makanan dan minuman pada daftar menu.

---

## ✨ Fitur Utama
1. **Splash / Welcome Screen**: Tampilan pembuka yang menarik dengan logo kopi, tagline *"Get a taste of your wish"*, dan tombol *"Start now"*.
2. **Sign Up Entry Screen**: Halaman pilihan awal untuk masuk (*Login*) atau mendaftar (*Register*).
3. **Login User**: Form autentikasi dengan input `username` dan `password`.
4. **Register**: Form pendaftaran anggota baru dengan input `nama lengkap`, `username`, dan `password`.
5. **Home Screen**: Menampilkan salam personal *"Halo [Nama],"*, kategori menu, serta daftar 5+ pilihan makanan dan minuman dengan foto, deskripsi, dan harga.
6. **Profile Screen**: Tampilan profil pengguna dengan fitur pembaruan nama pengguna secara real-time.
7. **Alamat Pengiriman (Order)**: Form pengisian alamat lengkap pengiriman pesanan (Nama Lengkap, Alamat, Patokan/Detail) dilengkapi ringkasan total pesanan.
8. **Konfirmasi Pesanan**: Layar konfirmasi berisi status badge hijau **OK**, ucapan terima kasih, dan info pengiriman kurir.
9. **Bottom Navigation**: Navigasi bawah untuk berpindah antar layar utama (**Home**, **Order**, **Profile**).

---

## 🛠️ Teknologi yang Digunakan
- **Bahasa Pemrograman**: [Kotlin](https://kotlinlang.org/)
- **UI Framework & Layout**: [Material Design 3](https://m3.material.io/), ConstraintLayout, MaterialCardView, ShapeableImageView
- **Navigasi**: Android Jetpack [Navigation Component](https://developer.android.com/guide/navigation) (`NavHostFragment`, `nav_graph`)
- **View Binding**: Android ViewBinding untuk tipe data UI aman (*type-safe UI binding*)
- **Minimum SDK**: API 27 (Android 8.1 Oreo)
- **Target & Compile SDK**: API 36

---

## 📱 Struktur Tampilan Wireframe

| No | Nama Layar | Class Fragment / Layout XML | Deskripsi Utama |
|---|---|---|---|
| 1 | **Splash / Welcome** | `SplashFragment` / `fragment_splash.xml` | Logo, Judul "Kopi dan Nyemil", Tagline, Tombol Start now |
| 2 | **Sign Up Entry** | `SignUpEntryFragment` / `fragment_sign_up_entry.xml` | Deskripsi gabung member, Tombol Register & Login |
| 3 | **Login User** | `LoginFragment` / `fragment_login.xml` | Input Username, Password, Tombol Login |
| 4 | **Register** | `RegisterFragment` / `fragment_register.xml` | Input Nama Lengkap, Username, Password, Tombol Register |
| 5 | **Home** | `HomeFragment` / `fragment_home.xml` | Header Halo Nama, Daftar Menu (RecyclerView), Bottom Nav |
| 6 | **Profile** | `ProfileFragment` / `fragment_profile.xml` | Profile Setting, Edit Nama, Tombol Save |
| 7 | **Alamat Pengiriman** | `AddressFragment` / `fragment_address.xml` | Input Nama Lengkap, Alamat, Patokan, Ringkasan & Tombol Order dan Kirim |
| 8 | **Konfirmasi Pesanan** | `ConfirmationFragment` / `fragment_confirmation.xml` | Badge OK hijau, Pesan Terima Kasih & Tombol Oke |

---

## 🚀 Cara Menjalankan Aplikasi

### Prasyarat
- **Android Studio**: Jellyfish / Koala / Ladybug (2024.1.1+) atau versi terbaru.
- **JDK**: Java 11 atau 17.
- **Android Device / Emulator**: Android 8.1 (API 27) atau lebih baru.

### Langkah-langkah
1. **Clone Repository**:
   ```bash
   git clone <URL_REPOSITORY_GITHUB_ANDA>
   cd DroidCafe
   ```
2. **Buka Project**:
   - Buka Android Studio, pilih **Open** dan pilih direktori folder project ini.
3. **Gradle Sync**:
   - Tunggu Android Studio melakukan sinkronisasi Gradle otomatis (`Sync Project with Gradle Files`).
4. **Jalankan Aplikasi**:
   - Pilih emulator atau perangkat Android fisik yang terhubung.
   - Klik tombol **Run 'app'** (`Shift + F10`) di Android Studio.

---

## 📸 Tampilan Layar (Screenshots)

Berikut ringkasan ke-8 antarmuka aplikasi **Kopi dan Nyemil**:

1. **1. Splash / Welcome** – Menampilkan logo kopi, judul aplikasi, tagline, dan tombol utama.
2. **2. Sign Up Entry** – Menampilkan instruksi pendaftaran beserta tombol Register dan Login.
3. **3. Login User** – Form login dengan validasi field username dan password.
4. **4. Register** – Form registrasi akun baru untuk pengguna.
5. **5. Home** – Menyajikan salam pengguna dan 5 item menu (Kopi Rasa Gula Aren, Donat Cokelat, Sourdough Loaf, Cappuccino, Matcha Latte) beserta tombol pesan.
6. **6. Profile** – Form pengaturan nama profil pengguna dengan tombol simpan.
7. **7. Alamat Pengiriman (Order)** – Input alamat pengiriman dan patokan serta ringkasan total belanja.
8. **8. Konfirmasi Pesanan** – Notifikasi sukses dengan simbol ikon hijau OK dan tombol Oke untuk kembali ke Home.
