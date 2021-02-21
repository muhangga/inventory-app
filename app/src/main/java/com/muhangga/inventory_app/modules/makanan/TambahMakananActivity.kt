/*
 *
 * Written By Muhamad Angga
 *
 */

package com.muhangga.inventory_app.modules.makanan

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.muhangga.inventory_app.R
import com.muhangga.inventory_app.models.MakananModel
import com.muhangga.inventory_app.utils.Preferences
import kotlinx.android.synthetic.main.activity_tambah_makanan.*

class TambahMakananActivity : AppCompatActivity() {

    private lateinit var mDatabase : DatabaseReference
    lateinit var preferences: Preferences
    lateinit var iNamaBarang : String
    lateinit var  iHarga : String
    lateinit var  iPcs : String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tambah_makanan)

        mDatabase = FirebaseDatabase.getInstance().getReference("Makanan")
        preferences = Preferences(this)

        btn_tambah.setOnClickListener {

            iNamaBarang = et_namabarang.text.toString()
            iHarga = et_harga.text.toString()
            iPcs = et_jumlah.text.toString()

            if (iNamaBarang.equals("")) {
                et_namabarang.error = "Silahkan isi nama barang"
                et_namabarang.requestFocus()
            }
            else if (iHarga.equals("")) {
                et_harga.error = "Silahkan isi harga barang"
                et_harga.requestFocus()
            }
            else if (iPcs.equals("")) {
                et_jumlah.error = "Silahkan isi jumlah barang"
                et_jumlah.requestFocus()
            }
            else {
                saveData(iNamaBarang, iHarga, iPcs)
            }
        }
    }

    private fun saveData(iNamaBarang: String, iHarga: String, iPcs: String) {

        var makanan = MakananModel()
        makanan.nama = iNamaBarang
        makanan.harga = iHarga
        makanan.pcs = iPcs.toInt()

        mDatabase.child(iNamaBarang).setValue(makanan).addOnCompleteListener {
            Toast.makeText(this, "Data berhasil ditambah!", Toast.LENGTH_LONG).show()

            startActivity(Intent(this, MakananActivity::class.java))
        }
        .addOnFailureListener {
            Toast.makeText(this, "Data gagal ditambahkan!", Toast.LENGTH_LONG).show()
        }
    }
}
