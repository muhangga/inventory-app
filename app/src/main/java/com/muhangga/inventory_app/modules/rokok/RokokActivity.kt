/*
 *
 * Written By Muhamad Angga
 *
 */

/*
 *
 * Written By Muhamad Angga
 *
 */

/*
 *
 * Written By Muhamad Angga
 *
 */

package com.muhangga.inventory_app.modules.rokok

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.muhangga.inventory_app.R
import com.muhangga.inventory_app.adapter.RokokAdapter
import com.muhangga.inventory_app.api.DummyRokok
import com.muhangga.inventory_app.models.RokokModel
import kotlinx.android.synthetic.main.activity_rokok.*


class RokokActivity : AppCompatActivity() {

    private var dataList = ArrayList<RokokModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rokok)

        rv_rokok.layoutManager = LinearLayoutManager(this)
        rv_rokok.adapter = RokokAdapter(dataList) {
            getData()
        }

        getData()
    }

    fun getData() {
        for (i in DummyRokok.namaRokok.indices) {
            dataList.add(
                RokokModel(
                    i + 1,
                    DummyRokok.namaRokok[i],
                    DummyRokok.hargaRokok[i],
                    DummyRokok.pcsRokok[i]
                )
            )
        }
    }
}