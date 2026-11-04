package lat.pam.kopidannyemil

import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class DataDummyTest {

    @Test
    fun daftarMenu_berisiEnamItem() {
        assertEquals(6, DataDummy.daftarMenu.size)
    }

    @Test
    fun setiapItem_punyaNamaDanHargaRupiah() {
        DataDummy.daftarMenu.forEach { item ->
            assertTrue(item.nama.isNotBlank())
            assertTrue("Harga tidak valid: ${item.harga}", item.harga.startsWith("Rp "))
        }
    }

    @Test
    fun labelPesanan_formatNamaDanHarga() {
        val item = DataDummy.daftarMenu.first()
        assertEquals("${item.nama} (${item.harga})", DataDummy.labelPesanan(item))
    }
}
