/*
 *
 * Written By Muhamad Angga
 *
 */

package com.muhangga.inventory_app.modules.minuman

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.muhangga.inventory_app.R
import com.muhangga.inventory_app.adapter.MinumanAdapter
import com.muhangga.inventory_app.api.DummyMinuman
import com.muhangga.inventory_app.models.MinumanModel
import kotlinx.android.synthetic.main.activity_minuman.*


class MinumanActivity : AppCompatActivity() {

    private var dataList = ArrayList<MinumanModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_minuman)

        rv_minuman.layoutManager = LinearLayoutManager(this)
        rv_minuman.adapter = MinumanAdapter(dataList) {
            getData()
        }

        getData()
    }

    fun getData() {
        for (i in DummyMinuman.namaMinuman.indices) {
            dataList.add(
                MinumanModel(
                    i + 1,
                    DummyMinuman.namaMinuman[i],
                    DummyMinuman.hargaMinuman[i],
                    DummyMinuman.pcsMinuman[i]
                )
            )
        }
    }
}