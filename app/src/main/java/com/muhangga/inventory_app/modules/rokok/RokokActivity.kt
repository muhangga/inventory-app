/*
 *
 * Written By Muhamad Angga
 *
 */

package com.muhangga.inventory_app.modules.rokok

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.database.*
import com.muhangga.inventory_app.R
import com.muhangga.inventory_app.adapter.RokokAdapter
import com.muhangga.inventory_app.api.DummyRokok
import com.muhangga.inventory_app.models.RokokModel
import com.muhangga.inventory_app.utils.Preferences
import kotlinx.android.synthetic.main.activity_rokok.*


class RokokActivity : AppCompatActivity() {

    private lateinit var preferences: Preferences
    private lateinit var mDatabase : DatabaseReference
    private var dataList = ArrayList<RokokModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rokok)

        preferences = Preferences(this)
        mDatabase = FirebaseDatabase.getInstance().getReference("Others")

        rv_rokok.layoutManager = LinearLayoutManager(this)
        getData()
    }

    fun getData() {

        mDatabase.addValueEventListener(object : ValueEventListener{
            override fun onCancelled(databaseError: DatabaseError) {
                Toast.makeText(this@RokokActivity, databaseError.message,
                    Toast.LENGTH_LONG).show()
            }

            override fun onDataChange(dataSnapshot: DataSnapshot) {

                for (Others in dataSnapshot.children) {
                    dataList.clear()

                    val others = Others.getValue(RokokModel::class.java)
                    dataList.add(others!!)
                }
                rv_rokok.adapter = RokokAdapter(dataList){

                }
            }


        })

    }
}