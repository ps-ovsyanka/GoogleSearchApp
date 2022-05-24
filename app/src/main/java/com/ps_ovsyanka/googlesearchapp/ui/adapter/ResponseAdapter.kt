package com.ps_ovsyanka.googlesearchapp.ui.adapter

import com.ps_ovsyanka.googlesearchapp.R
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ps_ovsyanka.googlesearchapp.data.Item
import kotlinx.android.synthetic.main.item_response.view.*

class ResponseAdapter : RecyclerView.Adapter<ResponseAdapter.ViewHolder>() {

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
            LayoutInflater.from(parent.context).inflate(R.layout.item_response, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ResponseAdapter.ViewHolder, position: Int) {
        val item = values[position]
        holder.title.text = item.title
        holder.link.text = item.link
        holder.snippet.text = item.snippet
    }

    override fun getItemCount(): Int = values.size

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val title: TextView = view.titleResponse
        val link: TextView = view.linkResponse
        val snippet: TextView = view.snippetResponse

        init {
            view.setOnClickListener {
                listener(it.linkResponse.text.toString())
            }
        }
    }

}