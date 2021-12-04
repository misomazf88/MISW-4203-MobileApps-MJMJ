package com.miso.vinilos.features.collector.ui.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.gson.Gson
import com.miso.vinilos.R
import com.miso.vinilos.features.artist.domain.entities.Artist
import com.miso.vinilos.features.collector.domain.entities.Collector

class CollectorDetailActivity : AppCompatActivity() {

    val gson = Gson()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val collector = gson.fromJson(intent.getStringExtra("collector"), Collector::class.java)
        setContentView(R.layout.activity_collector_detail)
        println("El coleccionista es: " + collector)
    }
}