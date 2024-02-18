package com.tanahku.beranda

import android.location.Geocoder
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.tanahku.R
import com.tanahku.core.domain.model.DataItemDomain
import com.tanahku.databinding.ItemDeviceBinding
import java.util.Locale

class ListDeviceAdapter: ListAdapter<DataItemDomain, ListDeviceAdapter.AdapterViewHolder>(DIFF_CALLBACK) {

    private lateinit var onItemClickCallback: OnItemClickCallback

    interface OnItemClickCallback {
        fun onClick(data: DataItemDomain)
    }

    fun setOnClickCallback(onItemClickCallback: OnItemClickCallback){
        this.onItemClickCallback = onItemClickCallback
    }

    inner class AdapterViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        fun bind(item: DataItemDomain) {
            val binding = ItemDeviceBinding.bind(itemView)
            binding.apply {
                val geocoder = Geocoder(itemView.context, Locale.getDefault())
                val loc = item.latitude?.toDouble()
                    ?.let { item.longitude?.toDouble()
                        ?.let { it1 -> geocoder.getFromLocation(it, it1,1) } }
                val address = loc?.get(0)?.getAddressLine(0).toString()
                fullAddress.text = address
                location.text = item.location
            }
            Log.e("adapterBind", "bind: $item")
            itemView.setOnClickListener{
                onItemClickCallback.onClick(item)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_device, parent, false)
        return AdapterViewHolder(view)
    }

    override fun onBindViewHolder(holder: AdapterViewHolder, position: Int) {
        return holder.bind(getItem(position))
    }

    companion object {
        val DIFF_CALLBACK = object : DiffUtil.ItemCallback<DataItemDomain>(){
            override fun areItemsTheSame(oldItem: DataItemDomain, newItem: DataItemDomain): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: DataItemDomain, newItem: DataItemDomain): Boolean {
                return oldItem == newItem
            }
        }
    }
}