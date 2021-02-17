/*
 *
 * Written By Muhamad Angga
 *
 */

package com.muhangga.inventory_app.kategori

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.muhangga.inventory_app.R
import com.muhangga.inventory_app.modules.makanan.MakananActivity
import kotlinx.android.synthetic.main.activity_kategori_barang.*

class KategoriBarangActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kategori_barang)

        btn_makanan.setOnClickListener {
            startActivity(Intent(this@KategoriBarangActivity, MakananActivity::class.java))
        }
    }
}
