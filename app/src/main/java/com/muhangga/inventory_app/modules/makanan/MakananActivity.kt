/*
 *
 * Written By Muhamad Angga
 *
 */

package com.muhangga.inventory_app.modules.makanan

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.muhangga.inventory_app.R
import com.muhangga.inventory_app.adapter.MakananAdapter
import com.muhangga.inventory_app.api.DummyMakanan
import com.muhangga.inventory_app.models.MakananModel
import kotlinx.android.synthetic.main.activity_makanan.*

class MakananActivity : AppCompatActivity() {

    private var dataList = ArrayList<MakananModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_makanan)

        rv_makanan.layoutManager = LinearLayoutManager(this)
        rv_makanan.adapter = MakananAdapter(dataList){
            getData()
        }

        getData()
    }

    fun getData() {
        for (i in DummyMakanan.namaMakanan.indices) {
            dataList.add(
                MakananModel(
                    i+1,
                    DummyMakanan.namaMakanan[i],
                    DummyMakanan.hargaMakanan[i],
                    DummyMakanan.pcsMakanan[i]
                )
            )
        }
    }
}