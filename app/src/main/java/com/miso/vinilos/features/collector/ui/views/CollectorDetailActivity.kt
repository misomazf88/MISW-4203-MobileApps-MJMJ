package com.miso.vinilos.features.collector.ui.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.google.gson.Gson
import com.miso.vinilos.R
import com.miso.vinilos.databinding.ActivityCollectorDetailBinding
import com.miso.vinilos.features.collector.domain.entities.Collector
import com.miso.vinilos.features.collector.ui.viewModels.CollectorDetailViewModel
import com.miso.vinilos.features.collector.ui.viewModels.CollectorDetailViewModelFactory
import kotlinx.coroutines.DelicateCoroutinesApi

@DelicateCoroutinesApi
class CollectorDetailActivity : AppCompatActivity() {

    val gson = Gson()
    private lateinit var viewModel: CollectorDetailViewModel
    private lateinit var binding: ActivityCollectorDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val collector = gson.fromJson(intent.getStringExtra("collector"), Collector::class.java)
        val viewModelFactory = CollectorDetailViewModelFactory.getInstance()
        viewModel = ViewModelProvider(this, viewModelFactory)[CollectorDetailViewModel::class.java]
        binding = DataBindingUtil.setContentView(this, R.layout.activity_collector_detail)
        binding.lifecycleOwner = this
        binding.vModel = viewModel
    }
}