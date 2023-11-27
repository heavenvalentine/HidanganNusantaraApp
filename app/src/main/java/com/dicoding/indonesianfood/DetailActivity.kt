package com.dicoding.indonesianfood

import android.os.Build
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DetailActivity : AppCompatActivity() {

    companion object {
        const val KEY_FOOD = "key_food"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val dataFood =  if (Build.VERSION.SDK_INT >= 33) {
            intent.getParcelableExtra<Food>(KEY_FOOD, Food::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra<Food>(KEY_FOOD)
        }

        if (dataFood != null) {
            val tvDetailName: TextView = findViewById(R.id.tv_detail_name)
            val tvDetailDescription: TextView = findViewById(R.id.tv_detail_description)
            val ivDetailPhoto: ImageView = findViewById(R.id.iv_detail_photo)

            tvDetailName.text = dataFood.name
            tvDetailDescription.text = dataFood.description
            ivDetailPhoto.setImageResource(dataFood.photo)
        }
    }
}
