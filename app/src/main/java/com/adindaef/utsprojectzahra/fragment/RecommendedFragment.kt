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
import com.adindaef.utsprojectzahra.adapter.RecommendedAdapter

class RecommendedFragment : Fragment() {

    private lateinit var adapter: RecommendedAdapter
    private lateinit var dataTitle: Array<String>
    private lateinit var dataDesc: Array<String>
    private lateinit var dataPhoto: TypedArray
    private var rec = arrayListOf<ModelMovie>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_recommended, container, false)

        val listView: ListView = view.findViewById(R.id.lvRecommended)
        adapter = RecommendedAdapter(view.context)
        listView.adapter = adapter

        dataTitle = resources.getStringArray(R.array.movie_title_recommended)
        dataDesc = resources.getStringArray(R.array.movie_desc_recommended)
        dataPhoto = resources.obtainTypedArray(R.array.movie_photo_recommended)

        for (position in dataTitle.indices){
            val recommended = ModelMovie(
                dataPhoto.getResourceId(position, -1),
                dataTitle[position],
                dataDesc[position]
            )
            rec.add(recommended)
        }
        adapter.recommended = rec

        listView.onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, id ->
            val intent = Intent(view.context, DetailActivity::class.java)
            intent.putExtra("extra_item", rec[position])
            startActivity(intent)
        }
        return view
    }
}