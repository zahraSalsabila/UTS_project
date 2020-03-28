package com.adindaef.utsprojectzahra

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val items = intent.getParcelableExtra<ModelMovie>("extra_item")

        dtl_title.text = items.title
        dtl_desc.text = items.desc
        dtl_photo.setImageResource(items.photo)
    }
}
