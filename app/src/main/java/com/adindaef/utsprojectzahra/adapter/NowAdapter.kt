package com.adindaef.utsprojectzahra.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.adindaef.utsprojectzahra.ModelMovie
import com.adindaef.utsprojectzahra.R

class NowAdapter internal constructor(private val context: Context) : BaseAdapter() {

    internal var nowshowing = arrayListOf<ModelMovie>()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var itemView = convertView
        if (itemView == null){
            itemView = LayoutInflater.from(context).inflate(R.layout.list_now, parent, false)
        }

        val viewHolder = ViewHolder(itemView as View)

        val nowpos = getItem(position) as ModelMovie
        viewHolder.bind(nowpos)

        return itemView
    }

    private inner class ViewHolder constructor(view: View) {
        private val titleMovie: TextView = view.findViewById(R.id.titleNow)
        private val descMovie: TextView = view.findViewById(R.id.descNow)
        private val imgMovie: ImageView = view.findViewById(R.id.imgNow)

        internal fun bind(nowpos: ModelMovie) {
            titleMovie.text = nowpos.title
            descMovie.text = nowpos.desc
            imgMovie.setImageResource(nowpos.photo)
        }
    }

    override fun getItem(position: Int): Any = nowshowing[position]

    override fun getItemId(position: Int): Long = position.toLong()

    override fun getCount(): Int = nowshowing.size
}