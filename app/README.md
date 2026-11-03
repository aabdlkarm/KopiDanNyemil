# ☕ Kopi dan Nyemil - Mobile App

Aplikasi mobile Android pemesanan kopi dan camilan yang dibangun menggunakan **Kotlin** dan **XML Views** di Android Studio. Proyek ini mengimplementasikan seluruh alur antarmuka dari wireframe **Kopi dan Nyemil** menggunakan penyimpanan data statis (*dummy data*) dan navigasi modern menggunakan **Bottom Navigation**.

---

## ✨ Fitur Utama

1. **Splash / Welcome Screen**: Halaman pembuka yang menampilkan logo aplikasi, slogan *"Get a taste of your wish"*, dan tombol mulai.
2. **Sign Up Screen**: Halaman orientasi anggota untuk memilih masuk ke akun (*Login*) atau membuat akun baru (*Register*).
3. **Login User**: Autentikasi masuk menggunakan *username* dan *password*.
4. **Register**: Pendaftaran pengguna baru dengan input nama lengkap, *username*, dan *password* yang langsung tersimpan pada sesi statis.
5. **Home (Daftar Makanan & Minuman)**: Menampilkan sapaan dinamis sesuai nama pengguna serta daftar 6 menu kopi dan camilan menggunakan `RecyclerView` lengkap dengan foto, deskripsi, dan harga.
6. **Profile**: Menampilkan informasi profil dan fitur *Profile Setting* untuk mengubah serta menyimpan nama pengguna secara langsung.
7. **Alamat Pengiriman (Order)**: Formulir pengiriman pesanan yang mencakup Nama Lengkap, Alamat, dan Patokan/Detail Lengkap.
8. **Konfirmasi Pesanan**: Halaman status pesanan berhasil dibuat sebelum dikembalikan ke halaman utama.
9. **Bottom Navigation**: Navigasi cepat antar halaman **Home**, **Order**, dan **Profile**.

---

## 🧭 Alur Penggunaan Aplikasi (User Flow)

    [1. Splash / Welcome] 
            │
            ▼
       [2. Sign Up] ──────► [3. Login User] ──┐
            │                                 │
            └─────────────► [4. Register] ────┤
                                              ▼
                       ┌───────────────► [5. Home] ◄───────────────┐
                       │                     │                     │
              (Tab Profile)             (Tab Order)                │
                       ▼                     ▼                     │
                 [6. Profile]     [7. Alamat Pengiriman]           │
                                             │                     │
                                     (Order dan Kirim)             │
                                             ▼                     │
                                  [8. Konfirmasi Pesanan] ─────────┘

---

## 🥐 Daftar Menu (Dummy Data)

| No | Nama Menu | Kategori | Deskripsi | Harga |
| :-: | :--- | :--- | :--- | :--- |
| 1 | **Kopi Susu Gula Aren** | Minuman | Espresso, susu, gula aren | Rp 22.000 |
| 2 | **Donat Cokelat** | Makanan | Donat empuk, glaze cokelat | Rp 12.000 |
| 3 | **Sourdough Loaf** | Makanan | Roti fermentasi alami | Rp 35.000 |
| 4 | **Cappuccino** | Minuman | Espresso, foam susu lembut | Rp 25.000 |
| 5 | **Matcha Latte** | Minuman | Matcha Jepang, susu segar | Rp 27.000 |
| 6 | **Butter Croissant** | Makanan | Pastry renyah berlapis mentega Prancis | Rp 18.000 |

---

## 🛠️ Teknologi & Komponen

* **Bahasa Pemrograman**: Kotlin
* **UI Layout**: XML (Android Views) & Material Design Components
* **Komponen Daftar**: `RecyclerView` dengan Custom Adapter (`MenuAdapter`)
* **Penyimpanan Data**: *In-Memory Static Object* (`DataDummy`) tanpa database
* **Package Name**: `lat.pam.kopidannyemil`

---

## 📂 Struktur Proyek

    app/src/main/
    ├── java/lat/pam/kopidannyemil/
    │   ├── SplashActivity.kt        # Layar 1: Splash / Welcome
    │   ├── SignUpActivity.kt        # Layar 2: Pilihan Register / Login
    │   ├── LoginActivity.kt         # Layar 3: Form Login User
    │   ├── RegisterActivity.kt      # Layar 4: Form Registrasi User
    │   ├── MainActivity.kt          # Layar 5, 6, 7: Home, Profile, & Order (BottomNav)
    │   ├── ConfirmationActivity.kt  # Layar 8: Konfirmasi Pesanan
    │   ├── MenuAdapter.kt           # Adapter RecyclerView untuk item menu
    │   └── DataDummy.kt             # Penyimpanan data statis user & daftar menu
    ├── res/
    │   ├── drawable/                # Aset foto menu dan logo aplikasi
    │   ├── layout/                  # File XML antarmuka (activity_*.xml & item_menu.xml)
    │   ├── menu/                    # Konfigurasi menu Bottom Navigation (bottom_nav_menu.xml)
    │   └── values/                  # Konfigurasi warna (colors.xml), teks, dan tema
    └── AndroidManifest.xml

---

## 🚀 Cara Menjalankan Proyek

1. Clone repositori ini ke komputer Anda:

       git clone https://github.com/aabdlkarm/KopiDanNyemil.git

2. Buka **Android Studio**, pilih **Open**, lalu arahkan ke folder proyek **KopiDanNyemil**.
3. Tunggu hingga proses **Gradle Sync** selesai.
4. Hubungkan perangkat Android fisik atau jalankan **Android Emulator**.
5. Klik tombol **Run 'app'** (ikon segitiga hijau) di bagian atas Android Studio.

---

## 👤 Pengembang

* **Nama**: Abdul Karim
* **NIM**: 1247050017
* **Mata Kuliah**: Pengembangan Aplikasi Mobile