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

class RecommendedAdapter internal constructor(private val context: Context) : BaseAdapter() {
    internal var recommended = arrayListOf<ModelMovie>()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var itemView = convertView
        if (itemView == null){
            itemView = LayoutInflater.from(context).inflate(R.layout.list_recommended, parent, false)
        }

        val viewHolder = ViewHolder(itemView as View)

        val recommendedpos = getItem(position) as ModelMovie
        viewHolder.bind(recommendedpos)

        return itemView
    }

    private inner class ViewHolder constructor(view: View) {
        private val titleMovie: TextView = view.findViewById(R.id.titleRecommended)
        private val descMovie: TextView = view.findViewById(R.id.descRecommended)
        private val imgMovie: ImageView = view.findViewById(R.id.imgRecommended)

        internal fun bind(recommendedpos: ModelMovie) {
            titleMovie.text = recommendedpos.title
            descMovie.text = recommendedpos.desc
            imgMovie.setImageResource(recommendedpos.photo)
        }
    }

    override fun getItem(position: Int): Any = recommended[position]

    override fun getItemId(position: Int): Long = position.toLong()

    override fun getCount(): Int = recommended.size
}