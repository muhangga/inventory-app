/*
 *
 * Written By Muhamad Angga
 *
 */

package com.muhangga.inventory_app.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.muhangga.inventory_app.R
import com.muhangga.inventory_app.models.MakananModel
import kotlinx.android.synthetic.main.item_makanan.view.*

class MakananAdapter (
    private  var data: List<MakananModel>,
    private val listener : (MakananModel) -> Unit
) : RecyclerView.Adapter<MakananAdapter.MakananViewHolder>() {

    lateinit var ContextAdapter : Context

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MakananViewHolder {

        val layoutInflater = LayoutInflater.from(parent.context)
        ContextAdapter = parent.context

        val inflatedView : View = layoutInflater.inflate(R.layout.item_makanan, parent, false)
        return MakananViewHolder(inflatedView)

    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: MakananViewHolder, position: Int) {
        holder.bindItem(data[position], listener, ContextAdapter, position)
    }


    class MakananViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val tvNama : TextView = view.findViewById(R.id.tv_nama)
        private val tvHarga : TextView = view.findViewById(R.id.tv_harga)
        private val tvPcs : TextView = view.findViewById(R.id.tv_pcs)

        fun bindItem(data : MakananModel, listener: (MakananModel) -> Unit, context: Context, position: Int) {
            tvNama.text = data.nama
            tvHarga.text = data.harga
            tvPcs.text = data.pcs.toString()

            itemView.setOnClickListener{
                listener(data)
            }
        }
    }

}
