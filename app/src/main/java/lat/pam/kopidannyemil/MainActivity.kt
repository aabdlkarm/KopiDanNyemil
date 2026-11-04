package lat.pam.kopidannyemil

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.ScrollView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationView

/**
 * Layar utama dengan Bottom Navigation: Home (menu), Order (alamat), dan Profile.
 */
class MainActivity : AppCompatActivity() {

    private lateinit var layoutHome: LinearLayout
    private lateinit var layoutOrder: ScrollView
    private lateinit var layoutProfile: LinearLayout
    private lateinit var bottomNav: BottomNavigationView

    private lateinit var tvGreetingHome: TextView
    private lateinit var tvGreetingProfile: TextView
    private lateinit var tvSelectedOrderInfo: TextView

    private lateinit var etOrderNama: EditText
    private lateinit var etOrderAlamat: EditText
    private lateinit var etOrderPatokan: EditText
    private lateinit var etProfileNama: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bindViews()
        setupDaftarMenu()
        setupBottomNavigation()
        setupProfileSave()
        setupOrderKirim()

        perbaruiSapaanNama()
    }

    private fun bindViews() {
        layoutHome = findViewById(R.id.layoutHome)
        layoutOrder = findViewById(R.id.layoutOrder)
        layoutProfile = findViewById(R.id.layoutProfile)
        bottomNav = findViewById(R.id.bottomNavigation)

        tvGreetingHome = findViewById(R.id.tvGreetingHome)
        tvGreetingProfile = findViewById(R.id.tvGreetingProfile)
        tvSelectedOrderInfo = findViewById(R.id.tvSelectedOrderInfo)

        etOrderNama = findViewById(R.id.etOrderNama)
        etOrderAlamat = findViewById(R.id.etOrderAlamat)
        etOrderPatokan = findViewById(R.id.etOrderPatokan)
        etProfileNama = findViewById(R.id.etProfileNama)
    }

    /** Daftar menu di halaman Home. Klik item akan memilihnya dan pindah ke tab Order. */
    private fun setupDaftarMenu() {
        val rvMenu = findViewById<RecyclerView>(R.id.rvMenu)
        rvMenu.layoutManager = LinearLayoutManager(this)
        rvMenu.adapter = MenuAdapter(DataDummy.daftarMenu) { item ->
            DataDummy.itemTerpilih = DataDummy.labelPesanan(item)
            Toast.makeText(
                this,
                "${item.nama} dipilih! Silakan isi alamat pengiriman.",
                Toast.LENGTH_SHORT
            ).show()
            bottomNav.selectedItemId = R.id.nav_order
        }
    }

    private fun setupBottomNavigation() {
        bottomNav.setOnItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.nav_home -> tampilkanHalaman(layoutHome)
                R.id.nav_order -> {
                    // Isi nama hanya jika kosong, agar ketikan pengguna tidak hilang saat pindah tab
                    if (etOrderNama.text.isNullOrBlank()) {
                        etOrderNama.setText(DataDummy.namaLengkap)
                    }
                    tvSelectedOrderInfo.text = "Pesanan: ${DataDummy.itemTerpilih}"
                    tampilkanHalaman(layoutOrder)
                }
                R.id.nav_profile -> {
                    etProfileNama.setText(DataDummy.namaLengkap)
                    tampilkanHalaman(layoutProfile)
                }
                else -> return@setOnItemSelectedListener false
            }
            true
        }
    }

    /** Hanya satu halaman yang terlihat; halaman lain disembunyikan. */
    private fun tampilkanHalaman(halaman: View) {
        listOf(layoutHome, layoutOrder, layoutProfile).forEach {
            it.visibility = if (it === halaman) View.VISIBLE else View.GONE
        }
    }

    private fun setupProfileSave() {
        findViewById<Button>(R.id.btnSaveProfile).setOnClickListener {
            val namaBaru = etProfileNama.text.toString().trim()
            if (namaBaru.isEmpty()) {
                Toast.makeText(this, "Nama tidak boleh kosong", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            DataDummy.namaLengkap = namaBaru
            perbaruiSapaanNama()
            Toast.makeText(this, "Profil berhasil diperbarui!", Toast.LENGTH_SHORT).show()
        }
    }

    private fun setupOrderKirim() {
        findViewById<Button>(R.id.btnOrderDanKirim).setOnClickListener {
            val namaPenerima = etOrderNama.text.toString().trim()
            val alamat = etOrderAlamat.text.toString().trim()
            val patokan = etOrderPatokan.text.toString().trim()

            if (namaPenerima.isEmpty() || alamat.isEmpty()) {
                Toast.makeText(
                    this,
                    "Harap isi Nama Lengkap dan Alamat Pengiriman",
                    Toast.LENGTH_SHORT
                ).show()
                return@setOnClickListener
            }

            DataDummy.namaLengkap = namaPenerima
            DataDummy.alamatPengiriman = alamat
            DataDummy.patokanAlamat = patokan
            perbaruiSapaanNama()

            startActivity(Intent(this, ConfirmationActivity::class.java))
        }
    }

    private fun perbaruiSapaanNama() {
        val sapaan = "Halo ${DataDummy.namaLengkap},"
        tvGreetingHome.text = sapaan
        tvGreetingProfile.text = sapaan
    }
}
