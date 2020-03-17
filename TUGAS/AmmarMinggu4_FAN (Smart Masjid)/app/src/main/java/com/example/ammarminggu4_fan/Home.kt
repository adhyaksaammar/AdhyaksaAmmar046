package com.example.ammarminggu4_fan

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.transition.Slide
import kotlinx.android.synthetic.main.activity_home.*

class Home : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val context = this

        identitas.setOnClickListener {
            val intent = Intent(context,IdentitasMasjid::class.java)
            startActivity(intent)
            finish()
        }

        jadwal.setOnClickListener {
            val intent = Intent(context,MainActivity::class.java)
            startActivity(intent)
            finish()
        }

        marquee.setOnClickListener {
            val intent = Intent(context,Marquee::class.java)
            startActivity(intent)
            finish()
        }

        pengumuman.setOnClickListener {
            val intent = Intent(context,Pengumuman::class.java)
            startActivity(intent)
            finish()
        }

        slideshow.setOnClickListener {
            val intent = Intent(context,Slideshow::class.java)
            startActivity(intent)
            finish()
        }

        tagline.setOnClickListener {
            val intent = Intent(context,Tagline::class.java)
            startActivity(intent)
            finish()
        }

    }
}
