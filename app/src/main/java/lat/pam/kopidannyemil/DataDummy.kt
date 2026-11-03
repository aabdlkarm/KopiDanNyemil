package lat.pam.kopidannyemil

data class MenuItem(
    val nama: String,
    val deskripsi: String,
    val harga: String,
    val kategori: String,
    val fotoResId: Int
)

object DataDummy {
    var namaLengkap: String = "Budi Santoso"
    var username: String = "budi"
    var password: String = "12345"

    var alamatPengiriman: String = ""
    var patokanAlamat: String = ""
    var itemTerpilih: String = "Kopi Susu Gula Aren"

    val daftarMenu = listOf(
        MenuItem(
            nama = "Kopi Susu Gula Aren",
            deskripsi = "Espresso, susu, gula aren",
            harga = "Rp 22.000",
            kategori = "Minuman",
            fotoResId = R.drawable.kopi_gula_aren
        ),
        MenuItem(
            nama = "Donat Cokelat",
            deskripsi = "Donat empuk, glaze cokelat",
            harga = "Rp 12.000",
            kategori = "Makanan",
            fotoResId = R.drawable.donat_cokelat
        ),
        MenuItem(
            nama = "Sourdough Loaf",
            deskripsi = "Roti fermentasi alami",
            harga = "Rp 35.000",
            kategori = "Makanan",
            fotoResId = R.drawable.sourdough
        ),
        MenuItem(
            nama = "Cappuccino",
            deskripsi = "Espresso, foam susu lembut",
            harga = "Rp 25.000",
            kategori = "Minuman",
            fotoResId = R.drawable.cappuccino
        ),
        MenuItem(
            nama = "Matcha Latte",
            deskripsi = "Matcha Jepang, susu segar",
            harga = "Rp 27.000",
            kategori = "Minuman",
            fotoResId = R.drawable.matcha_latte
        ),
        MenuItem(
            nama = "Butter Croissant",
            deskripsi = "Pastry renyah berlapis mentega Prancis",
            harga = "Rp 18.000",
            kategori = "Makanan",
            fotoResId = R.drawable.croissant
        )
    )
}