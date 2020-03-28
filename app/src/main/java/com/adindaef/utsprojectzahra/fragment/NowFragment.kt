package com.adindaef.utsprojectzahra.fragment

import android.content.Intent
import android.content.res.TypedArray
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ListView
import androidx.fragment.app.Fragment
import com.adindaef.utsprojectzahra.DetailActivity
import com.adindaef.utsprojectzahra.ModelMovie
import com.adindaef.utsprojectzahra.R
import com.adindaef.utsprojectzahra.adapter.NowAdapter

class NowFragment : Fragment() {

    private lateinit var adapter: NowAdapter
    private lateinit var dataTitle: Array<String>
    private lateinit var dataDesc: Array<String>
    private lateinit var dataPhoto: TypedArray
    private var now = arrayListOf<ModelMovie>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_now, container, false)

        val listView: ListView = view.findViewById(R.id.lvNow)
        adapter = NowAdapter(view.context)
        listView.adapter = adapter

        dataTitle = resources.getStringArray(R.array.movie_title_now)
        dataDesc = resources.getStringArray(R.array.movie_desc_now)
        dataPhoto = resources.obtainTypedArray(R.array.movie_photo_now)

        for (position in dataTitle.indices){
            val nowshowing = ModelMovie(
                dataPhoto.getResourceId(position, -1),
                dataTitle[position],
                dataDesc[position]
            )
            now.add(nowshowing)
        }
        adapter.nowshowing = now

        listView.onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, id ->
            val intent = Intent(view.context, DetailActivity::class.java)
            intent.putExtra("extra_item", now[position])
            startActivity(intent)
        }
        return view
    }
}