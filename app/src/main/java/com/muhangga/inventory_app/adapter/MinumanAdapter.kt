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

package com.muhangga.inventory_app.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.muhangga.inventory_app.R
import com.muhangga.inventory_app.models.MinumanModel

class MinumanAdapter (
    private  var data: List<MinumanModel>,
    private val listener : (MinumanModel) -> Unit
) : RecyclerView.Adapter<MinumanAdapter.MinumanViewHolder>() {

    lateinit var ContextAdapter : Context

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MinumanViewHolder {

        val layoutInflater = LayoutInflater.from(parent.context)
        ContextAdapter = parent.context

        val inflatedView : View = layoutInflater.inflate(R.layout.item_minuman, parent, false)
        return MinumanViewHolder(inflatedView)

    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: MinumanViewHolder, position: Int) {
        holder.bindItem(data[position], listener, ContextAdapter, position)
    }


    class MinumanViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val tvNama : TextView = view.findViewById(R.id.tv_nama)
        private val tvHarga : TextView = view.findViewById(R.id.tv_harga)
        private val tvPcs : TextView = view.findViewById(R.id.tv_pcs)

        fun bindItem(data : MinumanModel, listener: (MinumanModel) -> Unit, context: Context, position: Int) {
            tvNama.text = data.nama
            tvHarga.text = data.harga
            tvPcs.text = data.pcs.toString()

            itemView.setOnClickListener{
                listener(data)
            }
        }
    }

}
