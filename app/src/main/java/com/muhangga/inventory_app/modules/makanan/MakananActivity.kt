/*
 *
 * Written By Muhamad Angga
 *
 */

package com.muhangga.inventory_app.modules.makanan

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.database.*
import com.muhangga.inventory_app.R
import com.muhangga.inventory_app.adapter.MakananAdapter
import com.muhangga.inventory_app.api.DummyMakanan
import com.muhangga.inventory_app.models.MakananModel
import com.muhangga.inventory_app.utils.Preferences
import kotlinx.android.synthetic.main.activity_makanan.*
import kotlinx.android.synthetic.main.activity_tambah_makanan.*
import kotlinx.android.synthetic.main.item_makanan.*
import java.text.NumberFormat
import java.util.*
import kotlin.collections.ArrayList

class MakananActivity : AppCompatActivity() {

    private lateinit var preferences: Preferences
    private lateinit var mDatabase : DatabaseReference
    private var dataList = ArrayList<MakananModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_makanan)

        preferences = Preferences(this)
        mDatabase = FirebaseDatabase.getInstance().getReference("Makanan")

        rv_makanan.layoutManager = LinearLayoutManager(this)
        getData()

        iv_tambah.setOnClickListener {
            startActivity(Intent(this, TambahMakananActivity::class.java))
        }

    }

    fun getData() {
        mDatabase.addValueEventListener(object : ValueEventListener {
            override fun onCancelled(databaseError: DatabaseError) {
                Toast.makeText(this@MakananActivity, databaseError.message,
                    Toast.LENGTH_LONG).show()
            }

            override fun onDataChange(dataSnapshot: DataSnapshot) {
               dataList.clear()

                for (Makanan in dataSnapshot.children) {
                    val makanan = Makanan.getValue(MakananModel::class.java)
                    dataList.add(makanan!!)
                }

                rv_makanan.adapter = MakananAdapter(dataList) {
                    var intent = Intent(this@MakananActivity, EditMakananActivity::class.java)
                        .putExtra("data", it)
                    startActivity(intent)
                }
            }
        })
    }
}