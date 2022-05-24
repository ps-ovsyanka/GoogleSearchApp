package com.ps_ovsyanka.googlesearchapp.ui.adapter;

import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ps_ovsyanka.googlesearchapp.R
import com.ps_ovsyanka.googlesearchapp.data.Item
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_response.view.*
import kotlinx.android.synthetic.main.item_response_image.view.*

class ResponseImageAdapter : RecyclerView.Adapter<ResponseImageAdapter.ViewHolder>() {

    private var values: MutableList<Item> = mutableListOf()
    lateinit var listener: (String)->Unit

    fun refresh(list: List<Item>){
        values.clear()
        values.addAll(list)
        notifyDataSetChanged()
    }

    fun clear(){
        values.clear()
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_response_image, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ResponseImageAdapter.ViewHolder, position: Int) {
        val item = values[position]
        holder.link.text = item.image?.contextLink.toString()
        holder.itemView.setOnClickListener {
            listener(item.image?.contextLink.toString())
        }
        Picasso.get()
            .load(Uri.parse(item.image?.thumbnailLink))
            .fit()
            .centerCrop()
            .into(holder.image)

    }

    override fun getItemCount(): Int = values.size

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val image: ImageView = view.imageView
        val link: TextView = view.linkResponseImage
    }
}
