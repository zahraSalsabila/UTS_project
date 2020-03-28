package com.adindaef.utsprojectzahra.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.adindaef.utsprojectzahra.ModelMovie
import com.adindaef.utsprojectzahra.R

class SoonAdapter internal constructor(private val context: Context) : BaseAdapter() {
    internal var comingsoon = arrayListOf<ModelMovie>()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var itemView = convertView
        if (itemView == null){
            itemView = LayoutInflater.from(context).inflate(R.layout.list_soon, parent, false)
        }

        val viewHolder = ViewHolder(itemView as View)

        val soonpos = getItem(position) as ModelMovie
        viewHolder.bind(soonpos)

        return itemView
    }

    private inner class ViewHolder constructor(view: View) {
        private val titleMovie: TextView = view.findViewById(R.id.titleSoon)
        private val descMovie: TextView = view.findViewById(R.id.descSoon)
        private val imgMovie: ImageView = view.findViewById(R.id.imgSoon)

        internal fun bind(soonpos: ModelMovie) {
            titleMovie.text = soonpos.title
            descMovie.text = soonpos.desc
            imgMovie.setImageResource(soonpos.photo)
        }
    }

    override fun getItem(position: Int): Any = comingsoon[position]

    override fun getItemId(position: Int): Long = position.toLong()

    override fun getCount(): Int = comingsoon.size
}