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

class MainActivity : AppCompatActivity() {

    private lateinit var tvGreetingHome: TextView
    private lateinit var tvGreetingProfile: TextView
    private lateinit var tvSelectedOrderInfo: TextView
    private lateinit var etOrderNama: EditText
    private lateinit var etProfileNama: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val layoutHome = findViewById<LinearLayout>(R.id.layoutHome)
        val layoutOrder = findViewById<ScrollView>(R.id.layoutOrder)
        val layoutProfile = findViewById<LinearLayout>(R.id.layoutProfile)
        val bottomNav = findViewById<BottomNavigationView>(R.id.bottomNavigation)

        tvGreetingHome = findViewById(R.id.tvGreetingHome)
        tvGreetingProfile = findViewById(R.id.tvGreetingProfile)
        tvSelectedOrderInfo = findViewById(R.id.tvSelectedOrderInfo)
        etOrderNama = findViewById(R.id.etOrderNama)
        etProfileNama = findViewById(R.id.etProfileNama)

        val etOrderAlamat = findViewById<EditText>(R.id.etOrderAlamat)
        val etOrderPatokan = findViewById<EditText>(R.id.etOrderPatokan)
        val btnOrderDanKirim = findViewById<Button>(R.id.btnOrderDanKirim)
        val btnSaveProfile = findViewById<Button>(R.id.btnSaveProfile)

        // Perbarui tampilan nama pengguna
        perbaruiSapaanNama()

        // Setup RecyclerView Daftar Makanan/Minuman (6 Item)
        val rvMenu = findViewById<RecyclerView>(R.id.rvMenu)
        rvMenu.layoutManager = LinearLayoutManager(this)
        rvMenu.adapter = MenuAdapter(DataDummy.daftarMenu) { item ->
            DataDummy.itemTerpilih = "${item.nama} (${item.harga})"
            tvSelectedOrderInfo.text = "Pesanan: ${DataDummy.itemTerpilih}"
            Toast.makeText(this, "${item.nama} dipilih! Silakan isi alamat pengiriman.", Toast.LENGTH_SHORT).show()
            bottomNav.selectedItemId = R.id.nav_order
        }

        // Navigasi Bottom Navigation (Home, Order/Alamat, Profile)
        bottomNav.setOnItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.nav_home -> {
                    layoutHome.visibility = View.VISIBLE
                    layoutOrder.visibility = View.GONE
                    layoutProfile.visibility = View.GONE
                    true
                }
                R.id.nav_order -> {
                    etOrderNama.setText(DataDummy.namaLengkap)
                    tvSelectedOrderInfo.text = "Pesanan: ${DataDummy.itemTerpilih}"
                    layoutHome.visibility = View.GONE
                    layoutOrder.visibility = View.VISIBLE
                    layoutProfile.visibility = View.GONE
                    true
                }
                R.id.nav_profile -> {
                    etProfileNama.setText(DataDummy.namaLengkap)
                    layoutHome.visibility = View.GONE
                    layoutOrder.visibility = View.GONE
                    layoutProfile.visibility = View.VISIBLE
                    true
                }
                else -> false
            }
        }

        // Fitur Tombol "Save" pada Halaman Profile
        btnSaveProfile.setOnClickListener {
            val namaBaru = etProfileNama.text.toString().trim()
            if (namaBaru.isEmpty()) {
                Toast.makeText(this, "Nama tidak boleh kosong", Toast.LENGTH_SHORT).show()
            } else {
                DataDummy.namaLengkap = namaBaru
                perbaruiSapaanNama()
                Toast.makeText(this, "Profil berhasil diperbarui!", Toast.LENGTH_SHORT).show()
            }
        }

        // Fitur Tombol "Order dan Kirim" pada Halaman Alamat Pengiriman
        btnOrderDanKirim.setOnClickListener {
            val namaPenerima = etOrderNama.text.toString().trim()
            val alamat = etOrderAlamat.text.toString().trim()
            val patokan = etOrderPatokan.text.toString().trim()

            if (namaPenerima.isEmpty() || alamat.isEmpty()) {
                Toast.makeText(this, "Harap isi Nama Lengkap dan Alamat Pengiriman", Toast.LENGTH_SHORT).show()
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