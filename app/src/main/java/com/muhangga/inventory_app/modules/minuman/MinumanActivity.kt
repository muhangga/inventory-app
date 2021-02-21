/*
 *
 * Written By Muhamad Angga
 *
 */

package com.muhangga.inventory_app.modules.minuman

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.database.*
import com.muhangga.inventory_app.R
import com.muhangga.inventory_app.adapter.MinumanAdapter
import com.muhangga.inventory_app.api.DummyMinuman
import com.muhangga.inventory_app.models.MakananModel
import com.muhangga.inventory_app.models.MinumanModel
import com.muhangga.inventory_app.utils.Preferences
import kotlinx.android.synthetic.main.activity_minuman.*


class MinumanActivity : AppCompatActivity() {

    private lateinit var preferences: Preferences
    private lateinit var mDatabase : DatabaseReference
    private var dataList = ArrayList<MinumanModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_minuman)

        preferences = Preferences(this)
        mDatabase = FirebaseDatabase.getInstance().getReference("Minuman")

        rv_minuman.layoutManager = LinearLayoutManager(this)
        getData()
    }

    fun getData() {

        mDatabase.addValueEventListener(object : ValueEventListener {
            override fun onCancelled(databaseError: DatabaseError) {
                Toast.makeText(this@MinumanActivity, databaseError.message,
                    Toast.LENGTH_LONG).show()
            }

            override fun onDataChange(dataSnapshot: DataSnapshot) {

                dataList.clear()

                for (Minuman in dataSnapshot.children) {
                    val minuman = Minuman.getValue(MinumanModel::class.java)
                    dataList.add(minuman!!)
                }
                rv_minuman.adapter = MinumanAdapter(dataList) {

                }
            }

        })

    }
}